package com.routinestudy.shareliving.domain;

import com.routinestudy.shareliving.common.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Size(max = 20)
    private String username;
    @Size(max = 20)
    private String password;
    @Size(max = 18)
    private String nickname;

    @CreatedDate
    private Timestamp pwChangeDate;
    @Size(max = 20)
    private String insertId;
    @Size(max = 20)
    private String modifyId;

}
