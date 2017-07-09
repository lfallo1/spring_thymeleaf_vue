package guru.springframework.config.exception;

public abstract class RestServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ExceptionJSONInfo exceptionJSONInfo;

	public RestServiceException(String message) {
		super(message);
		this.generateExceptionJSONInfo();
	}

	public abstract void generateExceptionJSONInfo();

	public ExceptionJSONInfo getExceptionJSONInfo() {
		return exceptionJSONInfo;
	}

	public void setExceptionJSONInfo(ExceptionJSONInfo exceptionJSONInfo) {
		this.exceptionJSONInfo = exceptionJSONInfo;
	}

}
