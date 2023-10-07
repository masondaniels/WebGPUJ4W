package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

import java.io.Serializable;

/**
 * 
 * Any taken from the author listed below.
 * 
 * @author https://github.com/fluorumlabs/disconnect-project/blob/master/disconnect-classlib/src/main/java/js/lang/Any.java
 *
 */

interface AnyJS extends JSObject, Serializable {

	@JSBody(script = "return {};")
    static <T extends AnyJS> T empty() {
        throw new UnsupportedOperationException("Available only in JavaScript");
    }
}