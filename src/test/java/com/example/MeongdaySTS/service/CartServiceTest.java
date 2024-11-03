package com.example.MeongdaySTS.service;

import com.example.MeongdaySTS.cart.dto.CartDTO;
import com.example.MeongdaySTS.cart.service.CartService;
import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.member.repository.MemberRepository;
import com.example.MeongdaySTS.product.entity.Product;
import com.example.MeongdaySTS.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    CartService service;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void 카트담기(){

//        먼저 멤버 엔티티를 저장하여 외래 키 제약 조건을 만족하도록 설정
//        Member member = Member.builder()
//                .memberId("bbq5884")
//                .memberName("박춘봉2")
//                .MemberPw("1234")
//                .memberAddress("인천")
//                .memberRole("손님")
//                .memberEmail("1k@k.com")
//                .build();
//        memberRepository.save(member);

        Product product = productRepository.findByProductNo(1);
        int productCount = 3;

        CartDTO dto = CartDTO.builder()
                .cartNo(0)
                .memberId("bbq5883")
                .productNo(2)
                .productCount(productCount)
                .totalPrice(productCount * product.getProductPrice())
                .build();

        service.addCart(dto);

    }

    @Test
    public void 카트제거(){
        service.remove(1);

    }

    @Test
    public void 카트비우기(){
        service.removeAll("bbq5884");
    }
}
