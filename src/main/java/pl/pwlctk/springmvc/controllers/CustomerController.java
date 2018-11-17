package pl.pwlctk.springmvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.service.CustomerService;
import pl.pwlctk.springmvc.service.impl.CustomerServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    //CRUD
    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        Customer customer = service.getOne(id);
        model.addAttribute("customer", customer);
        return "customer";
    }

    @RequestMapping("/all")
    public String allCustomers(Model model) {
        List<Customer> allCustomers = service.getAll();
        model.addAttribute("allCustomers", allCustomers);
        return "customersList";
    }
}
