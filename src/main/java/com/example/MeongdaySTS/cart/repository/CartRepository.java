package com.example.MeongdaySTS.cart.repository;

import com.example.MeongdaySTS.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

Optional<Cart> findByMemberAndProduct(String memberId, int productNo);
// Select * from cart where member_id = :memberId And Product_no = :productNo;


// 조금 더 복잡한 쿼리 작성 시 @Query 사용하여 직접 작성 요망
@Query(value = "SELECT * FROM cart c JOIN member m ON c.member_id = m.mem_id WHERE m.mem_id = :memberId", nativeQuery = true)
List<Cart> findByMemberId(@Param("memberId") String memberId);
}
