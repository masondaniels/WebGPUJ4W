package coffee.mason.webgpuj4w.canvas;

import org.teavm.jso.JSBody;
import org.teavm.jso.browser.Window;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import coffee.mason.webgpuj4w.javascript.JavaScriptUtil;
import coffee.mason.webgpuj4w.javascript.WebGPUContext;
import coffee.mason.webgpuj4w.javascript.WebGPUInstance;

public abstract class WebGPUCanvas extends Canvas {

	private static final String NOT_SUPPORTED = "Your browser does not support WebGPU or it is not enabled. More info: https://webgpu.io";
	
	private WebGPUInstance webgpu;
	private double dpi;
	
	private WebGPUContext ctx;
	
	public WebGPUCanvas(boolean fullscreen, WebGPUInstance webgpu) {
		super("webgpu", fullscreen);
		this.webgpu = webgpu;
		if (isSupported()) {
			loadBeforeAnimation();
			updateCanvas(getCanvas());
			
			
			ctx = WebGPUContext.configureContext(getCanvas(), webgpu);

			if (fullscreen) {
				Window.current().addEventListener("resize", (e) -> {
					updateCanvas(getCanvas());
				});
			}

			requestAnimationFrame();
			loadAfterAnimation();
		} else {
			Window.current().alert(NOT_SUPPORTED);
		}
		
	}

	public void requestAnimationFrame() {
		Window.requestAnimationFrame(timestamp -> {
			update();
			draw();
			requestAnimationFrame();
		});
	}

	public void updateCanvas(HTMLCanvasElement canvas) {
		dpi = ((JSNumber) JavaScriptUtil.eval("window.devicePixelRatio || 1")).doubleValue();
		if (isFullscreen()) {
			canvas.setWidth((int) (Window.current().getInnerWidth() * dpi));
			canvas.setHeight((int) (Window.current().getInnerHeight() * dpi));
			setWidth(Window.current().getInnerWidth() * dpi);
			setHeight(Window.current().getInnerHeight() * dpi);
			canvas.getStyle().setProperty("width", Window.current().getInnerWidth() + "px");
			canvas.getStyle().setProperty("height", Window.current().getInnerHeight() + "px");
		}

		onResize();
	}
	
	public double getDPI() {
		return dpi;
	}
	
	public WebGPUContext getCtx() {
		return ctx;
	}

	public abstract void onResize();

	/*
	 * Supported Check if webgpu is supported
	 */

	@JSBody(script = "return navigator.gpu;")
	private static native boolean isGPUSupported(); // called only once ever

	private static boolean supported;
	private static boolean supportedCalled; // is supported called

	public static boolean isSupported() {
		if (!supportedCalled) {
			WebGPUCanvas.supported = isGPUSupported();
			supportedCalled = true;
		}
		return supported;
	}

}
