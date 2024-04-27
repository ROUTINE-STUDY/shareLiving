package com.routinestudy.shareliving.domain;

import com.routinestudy.shareliving.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor // 전체 파라미터 생성자
@NoArgsConstructor  // 기본 생성자
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String nickname;

    @CreatedDate
    private Timestamp pwChangeDate;
    private String insertId;
    private String modifyId;

}
