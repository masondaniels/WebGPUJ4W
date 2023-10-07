package coffee.mason.webgpuj4w.javascript;

interface WebGPUPassEncoderJS extends AnyJS {

	void setPipeline(WebGPUPipelineJS pipeline);

	void setBindGroup(int value, AnyJS bindGroup);

	void draw(int value);

	void end();

}