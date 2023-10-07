package coffee.mason.webgpuj4w.javascript.wrapper;

public class WebGPUShader {

	private WebGPUShaderType type;
	private String code;
	private String entryPoint = "main";

	public WebGPUShader(WebGPUShaderType type, String code) {
		this.type = type;
		this.code = code;
	}

	public WebGPUShaderType getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getEntryPoint() {
		return entryPoint;
	}
	
	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

}
