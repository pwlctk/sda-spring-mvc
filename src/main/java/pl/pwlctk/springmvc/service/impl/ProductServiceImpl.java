package pl.pwlctk.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pwlctk.springmvc.domain.Customer;
import pl.pwlctk.springmvc.domain.Product;
import pl.pwlctk.springmvc.repository.ProductRepository;
import pl.pwlctk.springmvc.service.ProductService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository repo;

    @Override
    public Product add(Product product) {
        repo.save(product);
        return product;
    }

    @Override
    public Product getOne(Long id) {
        Optional<Product> productOpt = repo.findById(id);
        Product product;
        if (productOpt.isPresent()) {
            product = productOpt.get();
        } else {
            product = new Product();
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        Iterable<Product> all = repo.findAll();
        List<Product> list = new LinkedList<>();
        for (Product p : all) {
            list.add(p);
        }
        return list;
    }

    @Override
    public Product update(Product product) {
        repo.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productOpt = repo.findById(id);
        Product product;
        if (productOpt.isPresent()) {
            product = productOpt.get();
            repo.delete(product);
        }
    }
}
