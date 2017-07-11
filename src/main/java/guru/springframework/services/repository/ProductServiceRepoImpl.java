package guru.springframework.services.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Product;
import guru.springframework.repositories.ProductRepository;
import guru.springframework.services.ProductService;

@Component
@Profile({"springdatajpa", "develop", "prod"})
public class ProductServiceRepoImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProduct(Integer id) {
		return this.productRepository.findOne(id);
	}

	@Override
	public List<Product> listProducts(Optional<Integer> category) {
		List<Product> products = new ArrayList<>();
		this.productRepository.findAll().forEach(p->products.add(p));
		return products;
	}

}
