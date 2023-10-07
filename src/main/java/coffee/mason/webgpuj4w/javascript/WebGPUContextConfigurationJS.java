package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUContextConfigurationJS extends AnyJS {

	@JSProperty
	WebGPUDeviceJS getDevice();

	@JSProperty()
	void setDevice(WebGPUDeviceJS device);

	@JSProperty
	JSObject getFormat();

	@JSProperty()
	void setFormat(JSObject format);

	@JSProperty
	String getAlphaMode();

	@JSProperty()
	void setAlphaMode(String alpha);

}
