package pl.pwlctk.springmvc.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pwlctk.springmvc.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
