package com.example.MeongdaySTS.cart.service;

import com.example.MeongdaySTS.cart.dto.CartDTO;
import com.example.MeongdaySTS.cart.entity.Cart;
import com.example.MeongdaySTS.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;

    @Override
    public int addCart(CartDTO dto) {

        Optional<Cart> optionalCart = repository.findByMemberAndProduct(dto.getMemberId(), dto.getProductNo());
        Cart cart;

        if(optionalCart.isPresent()){
            cart = optionalCart.get();
            cart.setProductCount(cart.getProductCount() + dto.getProductCount());
            cart.setTotalPrice(cart.getTotalPrice() + dto.getTotalPrice());
        }else {
            cart = dtoToEntity(dto);
            cart.setTotalPrice(cart.getProductCount() * cart.getProduct().getProductPrice());
        }
        Cart saveCart = repository.save(cart);

        return cart.getCartNo();
    }

    @Override
    public List<CartDTO> getListCart(String memberId) {
        List<Cart> entityList = repository.findByMemberId(memberId);
        List<CartDTO> dtoList = new ArrayList<>();
        dtoList = entityList.stream().map(this::entityToDto).toList();

        return dtoList;

    }
}
