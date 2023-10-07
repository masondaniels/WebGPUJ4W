package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUDeviceJS extends AnyJS {

	WebGPUPipelineJS createRenderPipeline(JSObject pipeline);
	
	AnyJS createShaderModule(WebGPUCodeJS pipeline);
	
	WebGPUCommandEncoderJS createCommandEncoder();

	@JSProperty
	WebGPUQueueJS getQueue();
	

	JSObject createBindGroupLayout(JSObject any);

	AnyJS createBindGroup(WebGPUBindGroupJS any);

	AnyJS createPipelineLayout(JSObject pipelineLayout);

	AnyJS createBuffer(AnyJS any);
	
	
	
}