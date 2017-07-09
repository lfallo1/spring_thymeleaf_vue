package guru.springframework.config.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RestServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedException(String message) {
		super(message);
	}
	
	@Override
	public void generateExceptionJSONInfo() {
		this.setExceptionJSONInfo(new ExceptionJSONInfo("", this.getMessage(), HttpStatus.UNAUTHORIZED));
	}

}
