package guru.springframework.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductWebService {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(){
		return new ResponseEntity<>(this.productService.listProducts(), HttpStatus.OK);
	}
	
}
