package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

interface WebGPUQueueJS extends AnyJS {

	void submit(JSObject queue);

	void writeBuffer(AnyJS a, int b, AnyJS c, int d);
}
