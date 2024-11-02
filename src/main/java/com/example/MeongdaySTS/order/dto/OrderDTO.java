package com.example.MeongdaySTS.order.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private int orderNo;            // 주문번호

    private String memberId;        // 주문하는(로그인한)아이디

    private String address;         // 주소

    private String detailedAddress; // 상세주소

    private String customerName;    // 수령인

    private String phoneNumber;     // 연락처

    private String postalCode;      // 우편번호

    private int totalPaymentAmount; // 총결제금액

//    List<OrderItemDTO> orderItems;  //실주문(OrderItem)을 위한 일대다

}
