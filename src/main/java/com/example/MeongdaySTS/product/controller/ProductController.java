package com.example.MeongdaySTS.product.controller;

import com.example.MeongdaySTS.product.dto.ProductDTO;
import com.example.MeongdaySTS.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody(뷰가 아닌 HTTP 응답 본문(body)으로 직렬화하여 전송할 때 사용. 주로 JSON 또는 XML 형태로 변환)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

//  ResponseEntity 클래스를 사용하면, 결과값, 상태코드, 헤더값을 모두 프론트에 넘겨줄 수 있고, 에러코드 또한 섬세하게 설정해서 보내줄 수 있다는 장점

//  ** 상품등록 나중에 권한주기 요망 **
    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestBody ProductDTO dto){
        int no = service.register(dto);
        return new ResponseEntity<>(no, HttpStatus.CREATED); // 200성공코드와 게시물 반환
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getList(){
        List<ProductDTO> dtoList = service.getList();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ProductDTO> read(@RequestBody int productNo){
        ProductDTO dto = service.read(productNo);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<ProductDTO> modify(@RequestBody ProductDTO dto){
        service.modify(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Integer> remove(@RequestParam(name = "productNo") int productNo){
        service.remove(productNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category")
    public ResponseEntity<List<ProductDTO>> getByCategory(@RequestParam(name = "productCategory") String productCategory){
        List<ProductDTO> list = service.getByCategory(productCategory);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
