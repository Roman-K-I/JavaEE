package com.gb.springthymeleafproduct.Repositories;

import com.gb.springthymeleafproduct.Product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findAll (Pageable pageable);


}
