package com.example.MeongdaySTS.cart.service;

import com.example.MeongdaySTS.cart.dto.CartDTO;
import com.example.MeongdaySTS.cart.entity.Cart;
import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.product.entity.Product;

import java.util.List;

public interface CartService {

    int addCart(CartDTO dto); //카트담기 수량, 총액
    List<CartDTO> getListCart(String memberId);


  default Cart dtoToEntity(CartDTO dto){
      Member member = Member.builder().memberId(dto.getMemberId()).build();     //회원(Member) 객체 생성
      Product product = Product.builder().productNo(dto.getProductNo()).build();    //상품 객체 생성

      return Cart.builder()
              .cartNo(dto.getCartNo())
              .memberId(member)
              .product(product)
              .productCount(dto.getProductCount())
              .totalPrice(dto.getTotalPrice())
              .build();
  }

  default CartDTO entityToDto(Cart entity){
      Member member = entity.getMemberId();

      return CartDTO.builder()
              .cartNo(entity.getCartNo())
              .memberId(member.toString())
              .productNo(entity.getProduct().getProductNo())
              .productCount(entity.getProductCount())
              .totalPrice(entity.getTotalPrice())
              .build();
  }
}
