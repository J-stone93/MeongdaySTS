package com.example.MeongdaySTS.service;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

//    컨테이너 안에 있는 빈을 주입받아, 객체 꺼내 ProductService service = new ProductService();
    @Autowired
    ProductService service;

    @Test
    public void 상품등록(){
        ProductDTO dto = ProductDTO.builder()
                .productNo(0)
                .productName("왕왕과자")
                .productPrice(20000)
                .productCategory("과자류")
                .productThembnail("썸넬사진222")
                .productDetailImage("상세사진222")
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
        dto.setProductThembnail("수정된더이쁜섬넬");
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
