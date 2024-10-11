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

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA에서 기본키값 자동 생성 지시
    private int cartNo;     //장바구니번호

    @ManyToOne
    @JoinColumn(name = "product_no") //외래키컬럼 이름지정
    private Product product;    //상품

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;    //해당 장바구니 담은 회원

    @Column(nullable = false)
    private int productCount;   //수량

    @Column(nullable = false)
    private int totalPrice;     //총액


}
