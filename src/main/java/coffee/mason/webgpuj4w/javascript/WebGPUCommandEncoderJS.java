package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSObject;

interface WebGPUCommandEncoderJS extends AnyJS {

	AnyJS beginRenderPass(JSObject renderPassDescriptor);

	AnyJS finish();

}