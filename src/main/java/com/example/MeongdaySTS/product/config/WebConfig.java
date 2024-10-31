package com.example.MeongdaySTS.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 첨부 파일의 경로를 맵핑하기 위한 설정 클래스
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Value("${webpath}")
    String webpath; //첨부 폴더 경로

    //스프링 보안문제로 외부폴더에 바로 접근할수 없음
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //폴더와 상대경로 맵핑
        registry.addResourceHandler("/uploadfile/**").addResourceLocations(webpath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 엔드포인트에 CORS 설정
                .allowedOrigins("http://localhost:3000") // 허용할 클라이언트 도메인 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메소드
                .allowedHeaders("*") // 허용할 헤더
                .allowCredentials(true); // 인증 정보 허용 여부
    }

}
