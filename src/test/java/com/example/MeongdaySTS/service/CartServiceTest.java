package com.example.MeongdaySTS.service;

import com.example.MeongdaySTS.cart.dto.CartDTO;
import com.example.MeongdaySTS.cart.service.CartService;
import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    CartService service;

//    @Test
//    public void 카트담기_수정(){
//        Member member = Member.builder().memberId("bbq5883").build();
//        Product product1 = Product.builder().productNo(1).build();
//        Product product2 = Product.builder().productNo(2).build();
//
//        CartDTO dto = CartDTO.builder()
//                .cartNo(0)
//                .memberId("bba5883").productNo(1).build();
//
//    }
}
