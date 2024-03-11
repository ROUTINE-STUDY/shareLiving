package com.routinestudy.shareliving.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor // 전체 파라미터 생성자
@NoArgsConstructor  // 기본 생성자
public class Hello {
    @Id
    private long id;
    private String name;
}
