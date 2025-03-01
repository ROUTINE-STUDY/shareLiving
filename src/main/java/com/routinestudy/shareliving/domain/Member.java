package com.routinestudy.shareliving.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자
public class Member {
  public Member(String name, int age, boolean isActiveMember) {
    this.name = name;
    this.age = age;
    this.isActiveMember = isActiveMember;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long id;
  private String name = "default";
  private int age = 0;
  private boolean isActiveMember = true;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean getIsActiveMember() {
    return isActiveMember;
  }
}
