package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView getProduct(@PathVariable Integer id){
		
		Product product = this.productService.getProduct(id);
		if(product != null){
			ModelAndView mv = new ModelAndView("product");
			mv.addObject("product", this.productService.getProduct(id));
			return mv;
		}
		return new ModelAndView("redirect:/");
	}
	
}
