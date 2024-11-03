package com.example.MeongdaySTS.productReview.service;

import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.product.entity.Product;
import com.example.MeongdaySTS.productReview.dto.ProductReviewDTO;
import com.example.MeongdaySTS.productReview.entity.ProductReview;

import java.util.List;

public interface ProductReviewService {

    //리뷰 등록(별점하기), 수정, 삭제

    int registerReview(ProductReviewDTO dto);   //리뷰 등록

    List<ProductReviewDTO> getReviewList(); //리뷰 목록보기

    ProductReviewDTO readReview(int productReviewNo); // 리뷰 상세보기

    void removeReview(int productReviewNo);


//    인터페이스 : 추상메소드만 가질 수 있다. + 자바 8버전 이후부터는 일반메소드 추가 가능(default 키워드요망)
    default ProductReview dtoToEntity(ProductReviewDTO dto){

        Member member = Member.builder().memberId(dto.getWriter()).build();
        Product product = Product.builder().productNo(dto.getProductNo()).build();

        ProductReview entity = ProductReview.builder()
                .productReviewNo(dto.getProductReviewNo())
                .product(product)
                .writer(member)
                .reviewContent(dto.getReviewContent())
                .reviewScore(dto.getReviewScore())
                .build();
        return entity;

    }

    default ProductReviewDTO entityToDto(ProductReview entity){

        ProductReviewDTO dto = ProductReviewDTO.builder()
                .productReviewNo(entity.getProductReviewNo())
                .productNo(entity.getProduct().getProductNo())
                .writer(entity.getWriter().getMemberId())
                .reviewContent(entity.getReviewContent())
                .reviewScore(entity.getReviewScore())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }

}
