package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.dom.html.HTMLCanvasElement;

public class WebGPUContext {

	private WebGPUContextJS ctx;

	public WebGPUContext(WebGPUContextJS ctx) {
		this.ctx = ctx;
	}

	public static WebGPUContext configureContext(HTMLCanvasElement canvas, WebGPUInstance webgpu) {
		WebGPUContextJS ctx = (WebGPUContextJS) canvas.getContext("webgpu");
		
		// Configure ctx
		WebGPUContextConfigurationJS ctxConfig = AnyJS.empty();
		ctxConfig.setDevice(webgpu.getDevice());
		ctxConfig.setAlphaMode("premultiplied");
		ctxConfig.setFormat(WebGPUInstance.getPresentationFormat());
		ctx.configure(ctxConfig);
		return new WebGPUContext(ctx);
		
	}

	protected WebGPUContextJS getCtxJS() {
		return ctx;
	}
	
	
}
