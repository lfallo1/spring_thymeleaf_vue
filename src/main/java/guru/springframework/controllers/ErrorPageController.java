package guru.springframework.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;

//@Controller
public class ErrorPageController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private ErrorService errorService;
//
//	@RequestMapping("/error")
//	public String redirectNonExistentUrlsToHome(HttpServletResponse response, Model model) throws IOException {
//		model.addAttribute("error", this.errorService.getErrorByStatus(response.getStatus()));
//		return "error";
//	}
//
//	@Override
//	public String getErrorPath() {
//		return "/error";
//	}
}