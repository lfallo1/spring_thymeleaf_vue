package guru.springframework.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Controller
public class IndexController {

	@Autowired
	private ProductService productService;

	@ModelAttribute("productList")
	public List<Product> listProducts(){
		return this.productService.listProducts();
	}
	
	@ModelAttribute("pageTitle")
	public String pageTitle(){
		return "Thymeleaf Home Page";
	}
	
	@RequestMapping("/")
	public ModelAndView getIndex(){
		return new ModelAndView("index");
	}
	
}
