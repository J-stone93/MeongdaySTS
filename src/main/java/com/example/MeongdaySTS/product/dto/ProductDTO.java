package com.example.MeongdaySTS.product.dto;

import lombok.*;

import java.time.LocalDateTime; 

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    int productNo;  //상품 고유번호

    String productName; //상품명

    int productPrice;   //상품가격

    String productCategory;     //상품카테고리

    String productContent;      //상품내용

    String productDetailImage;  //상품이미지

    LocalDateTime regDate;      //상품 등록일

    LocalDateTime modDate;      // 상품 등록 후 수정일

}
