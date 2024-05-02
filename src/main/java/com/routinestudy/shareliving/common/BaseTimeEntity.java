package com.routinestudy.shareliving.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 추상 클래스를 상속할 경우 아래 필드들을 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // Auditing 기능 포함 (JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime insertDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;
}
