package guru.springframework.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import guru.springframework.command.SignupNewsletterCommand;

@Controller
public class SignupNewsletterController {

	@RequestMapping("/newsletter")
	public String newsletter(Model model){
		model.addAttribute("signupNewsletterCommand", new SignupNewsletterCommand());
		return "newsletter";
	}
	
	@RequestMapping(value="/newsletter/signup", method=RequestMethod.POST)
	public String newsletterSignup(@Valid SignupNewsletterCommand signupNewsletterCommand, 
			BindingResult bindingResult, 
			Model model, 
			RedirectAttributes redirectAttributes){
		
		//if errors, just return to page with form object
		if(bindingResult.hasErrors()){
			model.addAttribute("signupform", signupNewsletterCommand);
			return "newsletter";
		}
		
		//otherwise redirect home with signup complete flash attribute
		redirectAttributes.addFlashAttribute("signupcomplete", true);
		return "redirect:/";
	}
	
}
