package com.example.MeongdaySTS.productReview.controller;

import com.example.MeongdaySTS.productReview.dto.ProductReviewDTO;
import com.example.MeongdaySTS.productReview.service.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController     //@Controller + @ResponseBody
@RequestMapping("/productReview")
public class ProductReviewController {

    @Autowired
    private ProductReviewService service;

    @PostMapping("/register")
    public ResponseEntity<Integer> registerReview(@RequestBody ProductReviewDTO dto){
        int reviewNo = service.registerReview(dto);
        return new ResponseEntity<>(reviewNo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductReviewDTO>> getReviewList(){
        List<ProductReviewDTO> reviewDTOList = service.getReviewList();
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewNo}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable int reviewNo){
        service.removeReview(reviewNo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
