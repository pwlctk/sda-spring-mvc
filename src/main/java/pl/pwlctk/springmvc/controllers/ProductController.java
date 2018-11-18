package pl.pwlctk.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pwlctk.springmvc.domain.Product;
import pl.pwlctk.springmvc.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    @RequestMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Product product = service.getOne(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping({"/all", "/"})
    public String allProducts(Model model) {
        List<Product> all = service.getAll();
        model.addAttribute("allProducts", all);
        return "productsList";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.delete(id);

        return "redirect:/product/all";
    }

    @RequestMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, Model model) {
        Product product = service.getOne(id);
        model.addAttribute("product", product);
        model.addAttribute("title", "Zmiana danych produktu");
        model.addAttribute("button", "Aktualizacja");

        return "productEdit";
    }

    @PostMapping("/update")
    public String saveCustomer(Product product) {
        Product update;
        if (product.getId() != null) {
            update = service.update(product);
        } else {
            update = service.add(product);
        }
        return "redirect:/product/" + update.getId();
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("title", "Dodawanie nowego produktu");
        model.addAttribute("button", "Dodaj");
        return "productEdit";
    }
}
