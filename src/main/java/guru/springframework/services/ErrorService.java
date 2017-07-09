package guru.springframework.services;

import org.springframework.stereotype.Service;

import guru.springframework.domain.ErrorDto;

@Service
public class ErrorService {

	public ErrorDto getErrorByStatus(int status) {
		switch (status) {
		case 404:
			return new ErrorDto("Page not be found", status, "Sorry but looks like the page you're searching for doesn't exist", null);
		case 500:
			return new ErrorDto("Internal Server Error", status, "Well, this is embarrassing.  May need to contact support for this one", "http://i1.kym-cdn.com/photos/images/newsfeed/000/510/778/b47");
		case 401:
		case 403:
			return new ErrorDto("Unauthorized", status, "Hmmm.... Me thinks you're trying to access something you shouldn't be.", "https://i.imgflip.com/1s85k8.jpg");
		}
		return new ErrorDto("This is strange", status, "Sorry, but we can't load the page you want at this time.  Please double check the url, and contact support if you feel this is an error", null);
	}

}
