package coffee.mason.webgpuj4w.javascript.wrapper;

public enum WebGPUVisibility {
	VERTEX(1), FRAGMENT(2), COMPUTE(4);

	private int value;

	private WebGPUVisibility(int value) {
		this.value = value;
	}

	public static int combine(WebGPUVisibility... visibilities) {
		int val = 0;
		for (WebGPUVisibility visibility : visibilities) {
			val |= visibility.getValue();
		}
		return val;
	}

	private int getValue() {
		return value;
	}
}
