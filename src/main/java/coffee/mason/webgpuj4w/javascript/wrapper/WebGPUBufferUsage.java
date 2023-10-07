package coffee.mason.webgpuj4w.javascript.wrapper;

public enum WebGPUBufferUsage {
	COPY_SRC(4), COPY_DST(8), INDEX(16), INDIRECT(256), MAP_READ(1), MAP_WRITE(2), QUERY_RESOLVE(512), STORAGE(128),
	UNIFORM(64), VERTEX(32);

	private int value;

	private WebGPUBufferUsage(int value) {
		this.value = value;
	}

	public static int combine(WebGPUBufferUsage... usages) {
		int val = 0;
		for (WebGPUBufferUsage usage : usages) {
			val |= usage.getValue();
		}
		return val;
	}

	private int getValue() {
		return value;
	}
}
