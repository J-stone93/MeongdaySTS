package com.example.MeongdaySTS.productReview.service;

import com.example.MeongdaySTS.productReview.dto.ProductReviewDTO;
import com.example.MeongdaySTS.productReview.entity.ProductReview;
import com.example.MeongdaySTS.productReview.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service    //서비스 클래스로 지정
public class ProductReviewServiceImpl implements ProductReviewService {

    @Autowired
    ProductReviewRepository repository;

    @Override
    public int registerReview(ProductReviewDTO dto) {
        ProductReview entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getProductReviewNo();
    }

    @Override
    public List<ProductReviewDTO> getReviewList() {
        List<ProductReview> entityList = repository.findAll();
        return entityList.stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public ProductReviewDTO readReview(int productReviewNo) {
        Optional<ProductReview> result = repository.findById(productReviewNo);
        if (result.isPresent()){
            ProductReview review = result.get();
            return entityToDto(review);
        }else {
            return null;
        }
    }

}
