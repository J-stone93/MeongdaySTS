package com.example.MeongdaySTS.product.repository;

import com.example.MeongdaySTS.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductCategory(String productCategory);
}
