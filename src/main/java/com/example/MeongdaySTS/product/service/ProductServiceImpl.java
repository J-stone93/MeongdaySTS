package com.example.MeongdaySTS.product.service;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.entity.Product;
import com.example.MeongdaySTS.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository repository;

    @Override
    public int register(ProductDTO dto) {
        Product entity = dtoToEntity(dto);
        repository.save(entity);    //리파지토리에 게시물 등록
        return entity.getProductNo();   //엔티티 게시물번호등록
    }

    @Override
    public List<ProductDTO> getList() {
        List<Product> result = repository.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        dtoList = result.stream().map(this::entityToDto).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public ProductDTO read(int productNo) {
        Optional<Product> result = repository.findById(productNo);
        if (result.isPresent()) {
            Product product = result.get();
//            ProductDTO productDTO = entityToDto(product);
//            return productDTO;
            return entityToDto(product);
        } else {
            return null;
        }
    }

    @Override
    public void modify(ProductDTO dto) {
        Optional<Product> result = repository.findById(dto.getProductNo());  //옵셔널데이터확인이유 : 동시성 이슈

        if (result.isPresent()) {
            Product product = result.get();
            product.setProductName(dto.getProductName());
            product.setProductPrice(dto.getProductPrice());
            product.setProductThembnail(dto.getProductThembnail());
            product.setProductDetailImage(dto.getProductDetailImage());
            product.setProductCategory(dto.getProductCategory());

            repository.save(product);
        }
    }

    @Override
    public int remove(int productNo) {
        Optional<Product> result = repository.findById(productNo);
        if (result.isPresent()) {
            repository.deleteById(productNo);
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public List<ProductDTO> getByCategory(String productCategory) {
        // findByProductCategory() : 프로덕트리포지토리에서 만든 추상메소드사용
        List<Product> products = repository.findByProductCategory(productCategory);

        // stream().map(e -> entityToDto(e)).collect(Collectors.toList()); 같은코드
        return products.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
