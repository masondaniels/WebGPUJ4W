package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.core.JSArray;

interface WebGPUTargetsConfigurationJS extends AnyJS {
	@JSProperty
	JSObject getFormat();

	@JSProperty()
	void setFormat(JSObject format);
}