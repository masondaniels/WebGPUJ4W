package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSProperty;

interface WebGPUCodeJS extends AnyJS {
	@JSProperty
	String getCode();

	@JSProperty()
	void setCode(String layout);
}