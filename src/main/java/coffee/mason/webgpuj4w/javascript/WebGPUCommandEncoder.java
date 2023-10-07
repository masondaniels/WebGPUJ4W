package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSNumber;

public class WebGPUCommandEncoder {

	private WebGPUCommandEncoderJS commandEncoder;
	private WebGPURenderPassDescriptorJS renderPassDescriptor;
	private WebGPUInstance webgpu;

	public WebGPUCommandEncoder(WebGPUCommandEncoderJS commandEncoder, WebGPUContext ctx, WebGPUInstance webgpu) {
		this.webgpu = webgpu;
		this.commandEncoder = commandEncoder;
		JSObject textureView = ((WebGPUCurrentTextureJS) (ctx.getCtxJS().getCurrentTexture())).createView();
		WebGPUColorAttachmentJS colorAttachment = AnyJS.empty();
		colorAttachment.setView(textureView);
		colorAttachment.setClearValue(WebGPUUtil.BLACK);
		colorAttachment.setLoadOp("clear");
		colorAttachment.setStoreOp("store");
		renderPassDescriptor = AnyJS.empty();
		renderPassDescriptor.setColorAttachments(JSArray.of(colorAttachment));

	}

	public WebGPUPassEncoder beginRenderPass() {
		return new WebGPUPassEncoder((WebGPUPassEncoderJS) commandEncoder.beginRenderPass(renderPassDescriptor));
	}

	public void submit() {
		WebGPUUtil.getDevice().getQueue().submit(JSArray.of(commandEncoder.finish()));
	}

	public void writeFloat(String name, float flote, int offset) {
		Float32Array toWrite = (Float32Array) Float32Array.of(flote);
		WebGPUUtil.getDevice().getQueue().writeBuffer(webgpu.getBuffer(name), offset, toWrite, 0);
	}
	
	public void writeInt(String name, int integer, int offset) {
		Int32Array toWrite = (Int32Array) Int32Array.of(integer);
		WebGPUUtil.getDevice().getQueue().writeBuffer(webgpu.getBuffer(name), offset, toWrite, 0);
	}
	
	public void writeUInt(String name, int integer, int offset) {
		UInt32Array toWrite = (UInt32Array) UInt32Array.of(integer);
		WebGPUUtil.getDevice().getQueue().writeBuffer(webgpu.getBuffer(name), offset, toWrite, 0);
	}

}
