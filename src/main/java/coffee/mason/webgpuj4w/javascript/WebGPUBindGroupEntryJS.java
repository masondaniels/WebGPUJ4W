package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUBindGroupEntryJS extends AnyJS {
	
	@JSProperty()
	void setBinding(int value);

	@JSProperty()
	void setResource(WebGPUBindGroupResourceJS any);

}
