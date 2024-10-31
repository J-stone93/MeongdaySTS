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
    int orderNo;

//    아이디 외래키
    @ManyToOne
    Member memberId;

//    주소
    @Column
    String address;

//    상세주소
    @Column
    String detailedAddress;

//    수령인

//    연락처
//    우편번호
//    총가격




}
