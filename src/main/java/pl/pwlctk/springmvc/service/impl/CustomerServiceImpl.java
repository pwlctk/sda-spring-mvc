package pl.pwlctk.springmvc.service.impl;

import org.springframework.stereotype.Service;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.service.CustomerService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Long, Customer> customers;

    public CustomerServiceImpl() {
        customers = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            Customer customer = new Customer();
            customer.setId((long) i);
            customer.setFirstName("Janusz");
            customer.setLastName("Mondry");
            customer.setAddressLine("Malmeda " + i);
            customer.setEmail("janusz@januszuszowy.pl");
            customer.setPhoneNumber("512 256 128");
            customer.setZipCode("15-100");
            customer.setCity("Mońki");
            customers.put((long) i, customer);
        }
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer getOne(Long id) {
        return customers.get(id);
    }

    @Override
    public List<Customer> getAll() {
        return new LinkedList<>(customers.values());
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(Long id) {
        customers.remove(id);
    }
}
