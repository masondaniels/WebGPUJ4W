package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

public class Float32Array implements AnyJS {

    @JSBody(params = "elements", script = "return new Float32Array(elements);")
    public static native JSObject of(float... elements);
	
}
