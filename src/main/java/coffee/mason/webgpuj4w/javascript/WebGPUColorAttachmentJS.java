package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUColorAttachmentJS extends AnyJS {

	@JSProperty
	JSObject getView();

	@JSProperty()
	void setView(JSObject view);

	@JSProperty
	WebGPUClearValueJS getClearValue();

	@JSProperty()
	void setClearValue(WebGPUClearValueJS object);

	@JSProperty()
	void setLoadOp(String loadOp);

	@JSProperty()
	void setStoreOp(String storeOp);
}
