package com.example.MeongdaySTS.member.repository;

import com.example.MeongdaySTS.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
