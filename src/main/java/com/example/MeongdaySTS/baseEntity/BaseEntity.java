package com.example.MeongdaySTS.baseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {

    @CreatedDate    //생성감지
    @Column(updatable = false)  //최초등록이기에 생성 후에 변하면 안되니까
    LocalDateTime regDate;

    @LastModifiedDate
    LocalDateTime modDate;
}
