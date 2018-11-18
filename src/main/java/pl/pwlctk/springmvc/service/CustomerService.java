package pl.pwlctk.springmvc.service;

import pl.pwlctk.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {
    //CRUD

    //C
    Customer add(Customer customer);

    //R
    Customer getOne(Long id);
    List<Customer> getAll();

    //U
    Customer update(Customer customer);

    //D
    void delete(Long id);
}
