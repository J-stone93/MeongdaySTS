package com.example.MeongdaySTS.product.service;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.entity.Product;

public interface ProductService {




    default Product dtoToEntity(ProductDTO dto){

        Product entity = Product.builder()
                .productNo(dto.getProductNo())
                .productName(dto.getProductName())
                .productPrice(dto.getProductPrice())
                .productThembnail(dto.getProductThembnail())
                .productDetailImage(dto.getProductDetailImage())
                .productCategory(dto.getProductCategory())
                .build();

        return entity;
    }

    default ProductDTO entityToDto(Product entity){

        ProductDTO dto = ProductDTO.builder()
                .productNo(entity.getProductNo())
                .productNo(entity.getProductNo())
                .productName(entity.getProductName())
                .productPrice(entity.getProductPrice())
                .productThembnail(entity.getProductThembnail())
                .productDetailImage(entity.getProductDetailImage())
                .productCategory(entity.getProductCategory())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }

//    테스트테스트
}



