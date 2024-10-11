package com.example.MeongdaySTS.cart.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {

    private int cartNo; //장바구니 번호

    private int productNo;    //상품

    private String memberId;  //회원

    private int productCount;   //수량

    private int totalPrice; //총액

}
