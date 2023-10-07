package coffee.mason.webgpuj4w.javascript.wrapper;

public class WebGPUBuffer {

	private int usage;
	private int size;
	private int binding;
	private int visibility;
	private WebGPUBufferType type;
	private String name;

	public WebGPUBuffer(String name, int binding, int size, WebGPUBufferType type, WebGPUVisibility[] visibility, WebGPUBufferUsage[] usages) {
		this.name = name;
		this.binding = binding;
		this.size = size;
		this.type = type;
		this.usage = WebGPUBufferUsage.combine(usages);
		this.visibility = WebGPUVisibility.combine(visibility);
	}

	public int getUsage() {
		return usage;
	}

	public int getSize() {
		return size;
	}

	public int getBinding() {
		return binding;
	}
	
	public String getType() {
		return type.toString().toLowerCase().replaceAll("_", "-");
	}

	public int getVisibility() {
		return visibility;
	}

	public String getName() {
		return name;
	}

}
