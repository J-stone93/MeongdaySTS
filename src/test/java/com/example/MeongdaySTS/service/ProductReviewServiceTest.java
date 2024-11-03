package com.example.MeongdaySTS.service;

import com.example.MeongdaySTS.productReview.dto.ProductReviewDTO;
import com.example.MeongdaySTS.productReview.service.ProductReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductReviewServiceTest {

    @Autowired
    ProductReviewService service;

    @Test
    public void 리뷰등록(){
        ProductReviewDTO reviewDto = ProductReviewDTO.builder()
                .productReviewNo(0)
                .productNo(1)
                .writer("bbq5883")
                .reviewScore(3)
                .reviewContent("잘먹어요 우리애기가")
                .build();
        service.registerReview(reviewDto);
    }

    @Test
    public void 리뷰목록조회(){
        List<ProductReviewDTO> reviewDTOList = service.getReviewList();
        for (ProductReviewDTO dto :reviewDTOList){
            System.out.println(dto);
        }
    }

    @Test
    public void 리뷰삭제(){
        service.removeReview(1);
    }

}
