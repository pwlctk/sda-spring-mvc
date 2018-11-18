package pl.pwlctk.springmvc.service;

import pl.pwlctk.springmvc.domain.Product;

import java.util.List;

public interface ProductService {
    //CRUD

    //C
    Product add(Product product);

    //R
    Product getOne(Long id);
    List<Product> getAll();

    //U
    Product update(Product product);

    //D
    void delete(Long id);
}
