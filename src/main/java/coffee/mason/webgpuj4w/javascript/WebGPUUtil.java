package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

import coffee.mason.webgpuj4w.javascript.PromiseJS.FullfilledValueVoidCallback;

public class WebGPUUtil {

	@JSBody(script = "async function getAdapter() {const adapter = await navigator.gpu.requestAdapter(); return adapter;} return getAdapter();")
	public static native JSObject getAdapterPromise();

	@JSBody(script = "async function getDevice() {const adapter = await navigator.gpu.requestAdapter(); const device = await adapter.requestDevice(); return device;} return getDevice();")
	public static native JSObject getDevicePromise();

	private static WebGPUDeviceJS device;
	private static boolean deviceCalled = false;

	public static WebGPUDeviceJS getDevice() {
		if (device == null && !deviceCalled) {
			deviceCalled = true;
			PromiseJS<AnyJS> promise = (PromiseJS) WebGPUUtil.getDevicePromise();
			promise.then(new FullfilledValueVoidCallback<AnyJS>() {

				@Override
				public void fullfilled(AnyJS value) {
					device = (WebGPUDeviceJS) value;
				}
			});
		}
		return device;
	}

	private static WebGPUAdapterJS adapter;
	private static boolean adapterCalled = false;

	public static WebGPUAdapterJS getAdapter() {
		if (adapter == null && !adapterCalled) {
			adapterCalled = true;
			PromiseJS<AnyJS> promise = (PromiseJS) WebGPUUtil.getAdapterPromise();
			promise.then(new FullfilledValueVoidCallback<AnyJS>() {

				@Override
				public void fullfilled(AnyJS value) {
					adapter = (WebGPUAdapterJS) value;
				}
			});
		}
		return adapter;

	}
	
	public static WebGPUClearValueJS BLACK;
	
	static {
		BLACK = AnyJS.empty();
		BLACK.setR(0);
		BLACK.setG(0);
		BLACK.setB(0);
		BLACK.setA(1);
	}
	
}
