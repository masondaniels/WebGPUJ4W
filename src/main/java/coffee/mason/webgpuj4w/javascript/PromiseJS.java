package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * 
 * Promise modified from disconnect-project.
 * 
 * @author https://github.com/fluorumlabs/disconnect-project/blob/master/disconnect-classlib/src/main/java/js/lang/Promise.java
 * @author Mason
 */

abstract class PromiseJS<T extends AnyJS> implements JSObject {
	
	
	@JSFunctor
    @FunctionalInterface
    public interface FullfilledValueVoidCallback<T extends AnyJS> extends JSObject {
		void fullfilled(T value);
    }
	
    public native PromiseJS then(FullfilledValueVoidCallback<T> onfulfilled);
    
}
