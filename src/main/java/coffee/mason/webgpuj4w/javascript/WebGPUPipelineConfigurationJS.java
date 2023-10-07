package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSProperty;

interface WebGPUPipelineConfigurationJS extends AnyJS {

	@JSProperty
	String getLayout();

	@JSProperty()
	void setLayout(AnyJS layout);

	@JSProperty
	WebGPUShaderConfigurationJS getVertex();

	@JSProperty()
	void setVertex(WebGPUShaderConfigurationJS config);

	@JSProperty
	WebGPUShaderConfigurationJS getFragment();

	@JSProperty()
	void setFragment(WebGPUShaderConfigurationJS config);

	@JSProperty
	WebGPUPrimitiveConfigurationJS getPrimitive();

	@JSProperty()
	void setPrimitive(WebGPUPrimitiveConfigurationJS config);

}
