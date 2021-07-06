package com.jlucas.productcatalog.controller;

import com.jlucas.productcatalog.model.Product;
import com.jlucas.productcatalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST)
    Product  create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Product> findById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
