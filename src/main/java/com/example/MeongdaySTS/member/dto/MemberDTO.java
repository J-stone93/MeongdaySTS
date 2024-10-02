package com.example.MeongdaySTS.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    String memberId;

    String MemberPw;

    String memberName;

    String memberEmail;

    String memberAddress;

    String memberRole;

    LocalDateTime regDate;

    LocalDateTime modDate;


}
