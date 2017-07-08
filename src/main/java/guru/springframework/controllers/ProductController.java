package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ModelAttribute("pageTitle")
	public String pageTitle(){
		return "Thymeleaf Products Page";
	}
	
	@RequestMapping("/product")
	public String redirectHome(){
		return "redirect:/";
	}
	
	@RequestMapping("/product/{id}")
	public ModelAndView getProduct(@PathVariable Integer id, Model model){
		
		Product product = this.productService.getProduct(id);
		if(product != null){
			model.addAttribute("product", this.productService.getProduct(id));
			return new ModelAndView("product");
		}
		return new ModelAndView("redirect:/");
	}
	
}
