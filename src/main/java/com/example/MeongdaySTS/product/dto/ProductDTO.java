package com.example.MeongdaySTS.product.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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

    String productContent;      //상품내용

    MultipartFile productDetailImage;  //파일 스트림 저장

    String productCategory;     //상품카테고리

    String imgPath; // 파일 이름 꺼내올때

    LocalDateTime regDate;      //상품 등록일

    LocalDateTime modDate;      // 상품 등록 후 수정일

}
