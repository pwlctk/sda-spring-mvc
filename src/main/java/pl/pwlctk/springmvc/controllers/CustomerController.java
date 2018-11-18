package pl.pwlctk.springmvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.service.CustomerService;

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

    @RequestMapping({"/all", "/"})
    public String allCustomers(Model model) {
        List<Customer> all = service.getAll();
        model.addAttribute("allCustomers", all);
        return "customersList";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.delete(id);

        return "redirect:/customer/all";
    }

    @RequestMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, Model model) {
        Customer customer = service.getOne(id);
        model.addAttribute("customer", customer);
        model.addAttribute("title", "Zmiana danych klienta");
        model.addAttribute("button", "Aktualizacja");

        return "customerEdit";
    }

    @PostMapping("/update")
    public String saveCustomer(Customer customer) {
        Customer update;
        if (customer.getId() != null) {
            update = service.update(customer);
        } else {
            update = service.add(customer);
        }
        return "redirect:/customer/" + update.getId();
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("title", "Dodawanie nowego klienta");
        model.addAttribute("button", "Dodaj");
        return "customerEdit";
    }


}
