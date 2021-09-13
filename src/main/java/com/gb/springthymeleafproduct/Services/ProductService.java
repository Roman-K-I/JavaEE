package com.gb.springthymeleafproduct.Services;

import com.gb.springthymeleafproduct.Product.Product;
import com.gb.springthymeleafproduct.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;
import static java.util.Objects.isNull;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return repository.findAll ();
    }

    public Product getProductById(Long id){
        return repository.findAllById (id);
    }

    public Page<Product> getProducts(Pageable pageable){
        return repository.findAll (pageable);
    }

    public void saveProduct(Product product){
        repository.save(product);
    }

    public Product getProduct () {
        return new Product();
    }

    public HttpStatus deleteProduct (Long id) {
        if (isNull(repository.findAllById (id))){
            return HttpStatus.NOT_FOUND;
        } else {
            repository.deleteById (id);
            return HttpStatus.OK;
        }
    }

    public Product saveOrUpdate (Product product) {
        return repository.save (product);
    }



}

