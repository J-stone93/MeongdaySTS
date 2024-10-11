package com.example.MeongdaySTS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing	//JPA 관련 자동 감사. Entity의 생성 시간, 수정 시간 등을 자동으로 기록
@SpringBootApplication
public class MeongdayStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeongdayStsApplication.class, args);
	}

}
