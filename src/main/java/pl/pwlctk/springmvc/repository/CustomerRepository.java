package pl.pwlctk.springmvc.repository;

import org.springframework.data.repository.CrudRepository;
import pl.pwlctk.springmvc.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
