package com.example.MeongdaySTS.cart.entity;

import com.example.MeongdaySTS.baseEntity.BaseEntity;
import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.product.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    // 장바구니번호
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA에서 기본키값 자동 생성 지시
    private int cartNo;

    // 상품
    @ManyToOne
    @JoinColumn(name = "product_no") // 외래키컬럼 이름지정
    private Product product;

    // 해당 장바구니를 담은 회원
    @ManyToOne
    @JoinColumn(name = "member_id") // 외래키 컬럼 이름
    private Member memberId; // memberId를 member로 변경

    // 상품수량
    @Column(nullable = false)
    private int productCount;

    // 상품총액
    @Column(nullable = false)
    private int totalPrice;
}