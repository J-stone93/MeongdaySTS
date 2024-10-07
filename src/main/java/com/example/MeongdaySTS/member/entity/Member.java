package com.example.MeongdaySTS.member.entity;

import com.example.MeongdaySTS.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Member extends BaseEntity {

    @Id
    @Column(length = 20)
    String memberId;

    @Column(length = 20, nullable = false)
    String MemberPw;

    @Column(length = 20, nullable = false)
    String memberName;

    @Column(length = 50)
    String memberEmail;

    @Column(length = 100, nullable = false)
    String memberAddress;

    @Column(length = 10, nullable = false)
    String memberRole;

}
