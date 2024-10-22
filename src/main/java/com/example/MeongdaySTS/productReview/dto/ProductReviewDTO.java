package com.example.MeongdaySTS.productReview.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReviewDTO {

    private int productReviewNo;

    private int productNo;  // 상품고유번호

    private String writer;  // 리뷰 쓰는 아이디

    private String ReviewContent; // 리뷰 내용

    private int ReviewScore; // 별점

    LocalDateTime regDate; // 별점 등록일

    LocalDateTime modDate; // 별점 수정일

}
