package com.routinestudy.shareliving.dto;

import com.routinestudy.shareliving.domain.Member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
  public MemberDto(Member user) {
    name = user.getName();
    age = user.getAge();
    isActiveMember = user.getIsActiveMember();
  }

  private String name;
  private int age;
  private boolean isActiveMember;

  public String getName() {
    return name;
  }

  public boolean getIsActiveMember() {
    return isActiveMember;
  }

  public int getAge() {
    return age;
  }
}
