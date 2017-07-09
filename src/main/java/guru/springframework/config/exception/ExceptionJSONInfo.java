package guru.springframework.config.exception;

import org.springframework.http.HttpStatus;

public class ExceptionJSONInfo {

	private String url;
	private String message;
	private HttpStatus status;

	public ExceptionJSONInfo() {
	}

	public ExceptionJSONInfo(String url, String message, HttpStatus status) {
		this.url = url;
		this.message = message;
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
