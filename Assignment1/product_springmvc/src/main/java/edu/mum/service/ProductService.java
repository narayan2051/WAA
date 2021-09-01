package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;

public interface ProductService {

    List<Product> getAll();

    void save(Product product);

    Product getById(int id);


}
 
