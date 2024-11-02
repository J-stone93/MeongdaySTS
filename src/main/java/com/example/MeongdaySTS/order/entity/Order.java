package com.example.MeongdaySTS.order.entity;

import com.example.MeongdaySTS.baseEntity.BaseEntity;
import com.example.MeongdaySTS.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

//    주문번호
    @Id     //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Jpa가기본키자동생성감지
    private int orderNo;

//    아이디 외래키
    @ManyToOne
    private Member memberId;

//    주소
    @Column
    private String address;

//    상세주소
    @Column
    private String detailedAddress;

//    수령인
    @Column(length = 30, nullable = false)
    private String customerName;

//    연락처
    @Column(length = 30, nullable = false)
    private String phoneNumber;

//    우편번호
    @Column(length = 6, nullable = false)
    private String postalCode;

//    총결제가격
    @Column(nullable = false)
    private int totalPaymentAmount;

//    일대다관계
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<OrderItem> orderItems = new ArrayList<>();




}
