package com.example.MeongdaySTS.service;

import com.example.MeongdaySTS.member.entity.Member;
import com.example.MeongdaySTS.member.repository.MemberRepository;
import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

//    컨테이너 안에 있는 빈을 주입받아, 객체 꺼내 ProductService service = new ProductService();
    @Autowired
    ProductService service;

    @Autowired
    MemberRepository memberRepository;

    MockMultipartFile mockFile = new MockMultipartFile(
            "productDetailImage",        // 1. Form field name (폼 필드 이름)
            "사진사진.jpg",                     // 2. Original file name (원본 파일 이름)
            "image/jpeg",                     // 3. Content type (파일 타입)
            "이미지데이터".getBytes()           // 4. File content (파일 내용, 바이트 배열로 전달)
    );

    @Test
    public void 외래키제약조건을위한_임시로멤버생성(){
        //        먼저 멤버 엔티티를 저장하여 외래 키 제약 조건을 만족하도록 설정
        Member member = Member.builder()
                .memberId("kim5883")
                .memberName("최자바")
                .MemberPw("1234")
                .memberAddress("서울")
                .memberRole("손님")
                .memberEmail("jj@k.com")
                .build();
        memberRepository.save(member);
    }

    @Test
    public void 상품등록(){
        ProductDTO dto = ProductDTO.builder()
                .productNo(0)
                .productName("멍멍이껌")
                .productPrice(4000)
                .productCategory("식음류")
                .productDetailImage(mockFile)
                .productContent("오래씹기좋은껌")
                .build();

        service.register(dto);
    }

    @Test
    public void 상품전체조회(){
        List<ProductDTO> dtoList = service.getList();
        for (ProductDTO dto : dtoList){
            System.out.println(dto);
        }
    }

    @Test
    public void 상품하나조회(){
        ProductDTO dto = service.read(6);
        System.out.println(dto);
    }

    @Test
    public void 상품수정(){
        ProductDTO dto = service.read(5);
        dto.setProductPrice(30000);
        service.modify(dto);
    }

    @Test
    public void 상품삭제(){
        service.remove(5);
    }

    @Test
    public void 카테고리별조회(){
        List<ProductDTO> dtoList = service.getByCategory("액체류");
        for(ProductDTO dto : dtoList){
            System.out.println(dto);
        }
    }
}
