package guru.springframework.services;

import java.util.List;
import java.util.Optional;

import guru.springframework.domain.Product;

/**
 * Created by jt on 1/26/16.
 */
public interface ProductService {

    Product getProduct(Integer id);

    List<Product> listProducts(Optional<Integer> category);
}
