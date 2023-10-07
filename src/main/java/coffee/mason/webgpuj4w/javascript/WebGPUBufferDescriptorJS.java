package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUBufferDescriptorJS extends AnyJS {

	@JSProperty()
	void setSize(int size);

	@JSProperty()
	void setUsage(JSObject usage);
}