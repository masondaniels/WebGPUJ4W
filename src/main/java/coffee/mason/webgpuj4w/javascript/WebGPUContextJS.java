package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;

public interface WebGPUContextJS extends AnyJS {

	AnyJS configure(JSObject configuration);

	AnyJS getCurrentTexture();

}
