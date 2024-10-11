package com.example.MeongdaySTS.product.service;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.entity.Product;

import java.util.List;

public interface ProductService {

    int register(ProductDTO dto);   // product(상품) 등록
    List<ProductDTO> getList();     // 상품 목록 보기
    ProductDTO read(int productNo); // 상품 상세 보기
    void modify(ProductDTO dto);    // 상품 수정
    int remove(int productNo);     // 상품 삭제
    List<ProductDTO> getByCategory(String productCategory);     //상품 카테고리별 목록 보기


    //	추상메소드만 가질 수 있다 + 자바8버전 이후부터는 일반메소드 추가 가능 -> default 키워드 요망

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



