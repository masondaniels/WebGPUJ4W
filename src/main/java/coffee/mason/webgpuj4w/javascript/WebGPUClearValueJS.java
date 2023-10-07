package coffee.mason.webgpuj4w.javascript;

import org.teavm.jso.JSProperty;

interface WebGPUClearValueJS extends AnyJS {

	@JSProperty()
	void setR(double r);

	@JSProperty()
	void setG(double g);

	@JSProperty()
	void setB(double b);

	@JSProperty()
	void setA(double a);

}
