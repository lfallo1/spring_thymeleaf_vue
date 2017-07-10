package guru.springframework.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	@Query(value="select * from product order by price desc limit 1", nativeQuery=true)
	public Product findMostExpensive();
}
