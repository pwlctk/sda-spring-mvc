package pl.pwlctk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.repository.CustomerRepository;
import pl.pwlctk.springmvc.service.CustomerService;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repo;

    @Override
    public Customer getOne(Long id) {
        Optional<Customer> customerOpt = repo.findById(id);
        Customer customer;
        if (customerOpt.isPresent()) {
            customer = customerOpt.get();
        } else {
            customer = new Customer();
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        Iterable<Customer> all = repo.findAll();
        List<Customer> list = new LinkedList<>();
        for (Customer c : all) {
            list.add(c);
        }
        return list;
    }

    @Override
    public Customer update(Customer customer) {
        repo.save(customer);
        return customer;
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customerOpt = repo.findById(id);
        Customer customer;
        if (customerOpt.isPresent()) {
            customer = customerOpt.get();
            repo.delete(customer);
        }
    }

    @Override
    public Customer add(Customer customer) {
        repo.save(customer);
        return customer;
    }
}
