package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSProperty;

interface WebGPUPrimitiveConfigurationJS extends AnyJS {
	@JSProperty
	String getTopology();

	@JSProperty()
	void setToplogy(String topology);
}