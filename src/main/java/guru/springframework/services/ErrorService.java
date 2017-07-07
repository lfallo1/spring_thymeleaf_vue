package guru.springframework.services;

import org.springframework.stereotype.Service;

import guru.springframework.domain.ErrorDto;

@Service
public class ErrorService {

	public ErrorDto getErrorByStatus(int status) {
		String msg = "";
		switch (status) {
		case 404:
			msg = "Page could not be found";
			break;
		case 500:
			msg = "Internal server error";
			break;
		case 401:
		case 403:
			msg = "Unauthorized";
			break;
		}
		return new ErrorDto(msg, status);
	}

}
