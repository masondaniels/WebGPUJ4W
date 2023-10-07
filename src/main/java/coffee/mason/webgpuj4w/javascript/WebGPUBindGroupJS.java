package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.core.JSArray;

interface WebGPUBindGroupJS extends AnyJS {

	@JSProperty()
	void setLayout(AnyJS bindGroupLayoutObject);

	@JSProperty()
	void setEntries(JSArray<WebGPUBindGroupEntryJS> entries);
	
}
