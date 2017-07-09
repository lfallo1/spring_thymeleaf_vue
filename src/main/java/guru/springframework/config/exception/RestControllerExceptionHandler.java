package guru.springframework.config.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Order(1) // NOTE: order 1 here
public class RestControllerExceptionHandler {
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Exception> returnRestServiceGenericException(HttpServletResponse response, AccessDeniedException e) {
		return new ResponseEntity<Exception>(e, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> returnRestServiceGenericException(HttpServletResponse response, Exception e) {
		return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}