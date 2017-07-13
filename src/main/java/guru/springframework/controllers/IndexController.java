package guru.springframework.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.config.AppProperties;
import guru.springframework.services.ProductService;

@Controller
public class IndexController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private AppProperties appProperties;

//	@ModelAttribute("productList")
//	public List<Product> listProducts(){
//		return this.productService.listProducts(null);
//	}
	
	@ModelAttribute("pageTitle")
	public String pageTitle(){
		return "My Thymeleaf Home Page";
	}
	
	@ModelAttribute("gitCommit")
	public String gitCommit(){
		return this.appProperties.getGitCommitId();
	}
	
	@RequestMapping("/")
	public ModelAndView getIndex(@RequestParam("category") Optional<Integer> category, Model model){
		model.addAttribute("filtered", category.isPresent());
		model.addAttribute("productList", this.productService.listProducts(category));
		return new ModelAndView("index");
	}
	
}
