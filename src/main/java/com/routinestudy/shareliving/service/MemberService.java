package com.routinestudy.shareliving.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.routinestudy.shareliving.repository.MemberRepository;
import com.routinestudy.shareliving.dto.MemberDto;
import com.routinestudy.shareliving.domain.Member;

public class MemberService {
  @Autowired
  private MemberRepository repository;

  public MemberDto getMember(long id) {
    Member user = repository.getReferenceById(id);
    MemberDto userDto = new MemberDto(user);

    return userDto;
  }
}
