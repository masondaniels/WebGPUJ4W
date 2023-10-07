package coffee.mason.webgpuj4w.javascript;

public class WebGPUPassEncoder {

	private WebGPUPassEncoderJS passEncoder;

	public WebGPUPassEncoder(WebGPUPassEncoderJS passEncoder) {
		this.passEncoder = passEncoder;
	}

	public void draw(int value) {
		passEncoder.draw(value);
	}
	
	public void end() {
		passEncoder.end();
	}

	public void setup(WebGPUInstance webgpu) {
		passEncoder.setPipeline(webgpu.getPipeline());
		passEncoder.setBindGroup(0, webgpu.getBindGroup());
		
	}

}
