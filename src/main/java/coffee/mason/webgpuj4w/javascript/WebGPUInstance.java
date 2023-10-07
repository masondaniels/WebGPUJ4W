package coffee.mason.webgpuj4w.javascript;

import java.util.HashMap;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;

import coffee.mason.webgpuj4w.javascript.wrapper.WebGPUBuffer;
import coffee.mason.webgpuj4w.javascript.wrapper.WebGPUConfiguration;
import coffee.mason.webgpuj4w.javascript.wrapper.WebGPUShader;
import coffee.mason.webgpuj4w.javascript.wrapper.WebGPUShaderType;

public class WebGPUInstance {

	private WebGPUDeviceJS device;
	private WebGPUContextJS ctx;
	private WebGPUPipelineJS pipeline;
	private AnyJS bindGroup;
	private HashMap<String, AnyJS> dataBuffers = new HashMap<String, AnyJS>();

	public WebGPUInstance(WebGPUConfiguration configuration) {
		WebGPUUtil.getDevice();

		// Waiting for promise to finish
		while (WebGPUUtil.getDevice() == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (WebGPUUtil.getDevice() != null) {
				break;
			}
		}

		device = WebGPUUtil.getDevice();

		WebGPUShader[] shaders = configuration.getShaders();
		WebGPUBuffer[] buffers = configuration.getBuffers();

		setupInstance(shaders, buffers);

	}

	private void setupInstance(WebGPUShader[] shaders, WebGPUBuffer[] buffers) {
		// Configure pipeline

		WebGPUPipelineConfigurationJS pipelineConfig = AnyJS.empty();

		// Create bind group layouts

		WebGPUBindGroupLayoutJS bindGroupLayout = AnyJS.empty();
		configureBindGroupLayoutEntries(bindGroupLayout, buffers);

		AnyJS bindGroupLayoutObject = (AnyJS) device.createBindGroupLayout(bindGroupLayout);

		createBufferObjects(buffers);

		WebGPUBindGroupJS bindGroupConfig = AnyJS.empty();
		bindGroupConfig.setLayout(bindGroupLayoutObject);
		WebGPUBindGroupEntryJS[] wbge = createBufferEntriesForConfig(buffers);
		bindGroupConfig.setEntries(JSArray.of(wbge));

		setBindGroup(device.createBindGroup(bindGroupConfig));

		// Create pipeline config using bind groups

		WebGPUPipelineLayoutJS pipelineLayout = AnyJS.empty();
		pipelineLayout.setBindGroupLayouts((AnyJS) JSArray.of(bindGroupLayoutObject));

		pipelineConfig.setLayout(device.createPipelineLayout(pipelineLayout));

		doShaderConfiguration(pipelineConfig, shaders);

		WebGPUPrimitiveConfigurationJS primitiveConfig = AnyJS.empty();
		primitiveConfig.setToplogy("triangle-list");
		pipelineConfig.setPrimitive(primitiveConfig);

		JavaScriptUtil.log(pipelineConfig);

		setPipeline(device.createRenderPipeline(pipelineConfig));
	}

	@JSBody(script = "return navigator.gpu.getPreferredCanvasFormat();")
	public static native JSObject getPresentationFormat();

	private void doShaderConfiguration(WebGPUPipelineConfigurationJS pipelineConfig, WebGPUShader[] shaders) {
		for (int i = 0; i < shaders.length; i++) {
			WebGPUShader shader = shaders[i];

			WebGPUCodeJS shaderCode = AnyJS.empty();
			shaderCode.setCode(shader.getCode());
			WebGPUShaderConfigurationJS shaderConfig = AnyJS.empty();
			shaderConfig.setModule(device.createShaderModule(shaderCode));
			shaderConfig.setEntryPoint(shader.getEntryPoint());
			WebGPUTargetsConfigurationJS targets = AnyJS.empty();
			targets.setFormat(getPresentationFormat());
			shaderConfig.setTargets(JSArray.of(targets));
			if (shader.getType().equals(WebGPUShaderType.FRAGMENT)) {
				pipelineConfig.setFragment(shaderConfig);
			} else if (shader.getType().equals(WebGPUShaderType.VERTEX)) {
				pipelineConfig.setVertex(shaderConfig);
			} else {
				// TODO: Implement compute shader
				System.err.println("Compute shader configuration not yet implemented! Ignoring compute shader.");
			}

		}

	}

	private WebGPUBindGroupEntryJS[] createBufferEntriesForConfig(WebGPUBuffer[] buffers) {
		WebGPUBindGroupEntryJS[] entries = new WebGPUBindGroupEntryJS[buffers.length];

		for (int i = 0; i < buffers.length; i++) {
			WebGPUBindGroupEntryJS wbge = AnyJS.empty();
			wbge.setBinding(buffers[i].getBinding());
			WebGPUBindGroupResourceJS resource = AnyJS.empty();
			resource.setBuffer(dataBuffers.get(buffers[i].getName()));
			wbge.setResource(resource);
			entries[i] = wbge;
		}

		return entries;
	}

	private void createBufferObjects(WebGPUBuffer[] buffers) {

		for (int i = 0; i < buffers.length; i++) {
			WebGPUBufferDescriptorJS bufferDescriptor = AnyJS.empty();
			bufferDescriptor.setSize(buffers[i].getSize());
			bufferDescriptor.setUsage(JavaScriptUtil.eval(buffers[i].getUsage() + ""));
			dataBuffers.put(buffers[i].getName(), (AnyJS) device.createBuffer(bufferDescriptor));
		}

	}

	private void configureBindGroupLayoutEntries(WebGPUBindGroupLayoutJS bindGroupLayout, WebGPUBuffer[] buffers) {

		WebGPUBindGroupLayoutEntryJS[] layoutEntries = new WebGPUBindGroupLayoutEntryJS[buffers.length];
		for (int i = 0; i < buffers.length; i++) {
			WebGPUBuffer buffer = buffers[i];
			WebGPUBindGroupLayoutEntryJS layoutEntry = AnyJS.empty();
			layoutEntry.setBinding(buffer.getBinding());
			layoutEntry.setVisibility(JavaScriptUtil.eval(buffer.getVisibility() + ""));
			WebGPUBufferJS wgbjs = AnyJS.empty();
			wgbjs.setType(buffer.getType());
			layoutEntry.setBuffer(wgbjs);

			layoutEntries[i] = layoutEntry;

		}
		bindGroupLayout.setEntries(JSArray.of(layoutEntries));

	}

	public WebGPUCommandEncoder createCommandEncoder(WebGPUContext ctx) {
		return new WebGPUCommandEncoder(device.createCommandEncoder(), ctx, this);
	}

	protected WebGPUPipelineJS getPipeline() {
		return pipeline;
	}

	protected void setPipeline(WebGPUPipelineJS pipeline) {
		this.pipeline = pipeline;
	}

	public WebGPUDeviceJS getDevice() {
		return device;
	}

	protected void setBindGroup(AnyJS bindGroup) {
		this.bindGroup = bindGroup;
	}

	protected AnyJS getBindGroup() {
		return bindGroup;
	}

	public AnyJS getBuffer(String name) {
		return dataBuffers.get(name);
	}

}
