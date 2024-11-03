package com.example.MeongdaySTS.productReview.entity;

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
public class ProductReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //JPA가 자동으로 생성지시
    private int productReviewNo;

//    상품고유번호
    @ManyToOne
    @JoinColumn(name = "product_no")    //외래키컬럼이름지정
    private Product product;

//    리뷰 쓰는 아이디
    @ManyToOne
    private Member writer;

//    리뷰 내용
    @Column(length = 1000, nullable = false)
    private String reviewContent;

//    별점
    @Column
    private int reviewScore;

}
