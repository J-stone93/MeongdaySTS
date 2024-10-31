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

public class Product extends BaseEntity {

    @Id     //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA에서 기본 키의 값을 자동으로 생성하도록 지시
    private int productNo;  //상품 고유번호

    @Column(length = 20, nullable = false)
    String productName; // 상품명
    
    @Column(length = 600, nullable = false)
    String productContent; //상풍내용

    @Column(length = 10, nullable = false)
    int productPrice;   //상품가격

    @Column(length = 200, nullable = false)
    private String imgPath; //첨부파일 이름

    @Column(length = 10, nullable = false)
    String productCategory;     //상품카테고리

}
