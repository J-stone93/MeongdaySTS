package com.example.MeongdaySTS.cart.controller;

import com.example.MeongdaySTS.cart.dto.CartDTO;
import com.example.MeongdaySTS.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody 응답 -> 보내줄 데이터를 JSON 등으로 변환 시 사용
@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping("/addCart")
    public ResponseEntity<String> addCart(@RequestBody CartDTO dto){
        int no = service.addCart(dto);
        return ResponseEntity.ok("장바구니에 잘 담겼어요. 장바구니 번호: " + no);
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getList(@RequestParam(name = "memberId") String memberId) {
        List<CartDTO> cartList = service.getListCart(memberId);
        return new ResponseEntity<>(cartList, HttpStatus.OK);
    }

    @DeleteMapping("/delCart")
    public ResponseEntity<Integer> remove(@RequestParam(name = "cartNo") int cartNo){
        service.remove(cartNo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delAllCart")
    public ResponseEntity<String> allRemove(@RequestParam(name="memberId") String memberId){
        service.removeAll(memberId);
        return ResponseEntity.ok("장바구니 전체삭제 완료");
    }
}
