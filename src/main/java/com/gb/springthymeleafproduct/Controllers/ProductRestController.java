package com.gb.springthymeleafproduct.Controllers;

import com.gb.springthymeleafproduct.Product.Product;
import com.gb.springthymeleafproduct.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private ProductService service;

//    GET
    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts ();
    }

//    GET
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long productId){
        return service.getProductById (productId);
    }

//    POST
    @PostMapping( "/products")
    public Product addProduct(@RequestBody Product product){
        return service.saveOrUpdate(product);
    }

//    PUT
    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product){
        return service.saveOrUpdate(product);
    }

//    DELETE
    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable("id") Long productId){
        return service.deleteProduct (productId);
    }

}
