package guru.springframework.webservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductWebService {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET)
	@PreAuthorize("@restServicePreAuth.hasRole(#auth, 'ROLE_SUPERHERO')")
	public ResponseEntity<List<Product>> getProducts(Authentication auth, @RequestParam("category") Optional<Integer> category) {
		return new ResponseEntity<>(this.productService.listProducts(category), HttpStatus.OK);
	}
	
}
