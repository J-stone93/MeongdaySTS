package com.example.MeongdaySTS.repository;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.entity.Product;
import com.example.MeongdaySTS.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectColumnProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Test
    void 빈을_가졌는지_확인(){
        System.out.println("ProductRepository: " + repository);
    }

    @Test
    void 프로덕트_상품_등록(){
        Product product = Product.builder()
                .productNo(0)
                .productName("애견소주")
                .productPrice(3000)
                .productThembnail("썸넬1")
                .productDetailImage("상세사진2")
                .productCategory("액체")
                .build();
        repository.save(product);
    }

    @Test
    void 상품목록조회(){
        List<Product> productList = repository.findAll();
        System.out.println("회원목록: " );
        for (Product all : productList){
            System.out.println(all);
        }
    }

    @Test
    void 상품조회(){
        Optional<Product> result = repository.findById(2);
        if(result.isPresent()){
            Product product =result.get();
            System.out.println(product);
        }
    }

    @Test
    void 상풍수정(){
        Optional<Product> productMod = repository.findById(3);
        Product product = productMod.get();
        product.setProductName("애견맥주");
        product.setProductCategory("액체");
        product.setProductPrice(10000);
        repository.save(product);
    }

    @Test
    void 게시물삭제(){
        repository.deleteById(1);
    }


    @Test
    void 게시물전체삭제(){
        repository.deleteAll();
    }


}
