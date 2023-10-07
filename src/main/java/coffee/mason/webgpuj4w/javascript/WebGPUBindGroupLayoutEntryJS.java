package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUBindGroupLayoutEntryJS extends AnyJS {
	
	@JSProperty()
	void setBinding(int any);

	@JSProperty()
	void setVisibility(JSObject any);

	@JSProperty()
	void setBuffer(AnyJS any);

}
