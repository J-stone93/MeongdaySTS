package com.example.MeongdaySTS.product.entity;

import com.example.MeongdaySTS.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class productEntity extends BaseEntity {

    @Id     //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA에서 기본 키의 값을 자동으로 생성하도록 지시
    int productNo;  //상품 고유번호

    @Column(length = 10)
    String productName; // 상품명

    int productPrice;   //상품가격

    String productThembnail;    //썸네일

    String productDetailImage;  //상품이미지

    String productCategory;     //상품카테고리

}
