package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.command.LoginCommand;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLoginForm(Model model) {

		model.addAttribute("loginCommand", new LoginCommand());

		return "loginform";
	}
	//
	// @RequestMapping(value = "/dologin", method = RequestMethod.POST)
	// public String doLogin(@Valid LoginCommand loginCommand, BindingResult
	// bindingResult){
	//
	// if(bindingResult.hasErrors()){
	// return "loginform";
	// }
	//
	// return "redirect:index";
	// }

}
