package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.core.JSArray;

interface WebGPUShaderConfigurationJS extends AnyJS {
	@JSProperty
	String getEntryPoint();

	@JSProperty()
	void setEntryPoint(String entry);

	@JSProperty
	JSObject getModule();

	@JSProperty()
	void setModule(JSObject object);

	@JSProperty
	JSArray<WebGPUTargetsConfigurationJS> getTargets();

	@JSProperty()
	void setTargets(JSArray<WebGPUTargetsConfigurationJS> object);

}