package pl.pwlctk.springmvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    //CRUD
    private CustomerService service;

    @Autowired
    public void setService(CustomerService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public Customer showUser(@PathVariable Long id) {
        return this.service.getOne(id);
    }

    @RequestMapping({"/all", "/"})
    public List<Customer> allCustomers() {
        return this.service.getAll();
    }

    @RequestMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        this.service.delete(id);

    }
//
//    @RequestMapping("/update/{id}")
//    public String updateCustomer(@PathVariable Long id, Model model) {
//        Customer customer = service.getOne(id);
//        model.addAttribute("customer", customer);
//        model.addAttribute("title", "Zmiana danych klienta");
//        model.addAttribute("button", "Aktualizacja");
//
//        return "customerEdit";
//    }
//
//    @PostMapping("/update")
//    public String saveCustomer(Customer customer) {
//        Customer update;
//        if (customer.getId() != null) {
//            update = service.update(customer);
//        } else {
//            update = service.add(customer);
//        }
//        return "redirect:/customer/" + update.getId();
//    }
//
    @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void newCustomer(@RequestBody Customer customer) {
        this.service.add(customer);

    }


}
