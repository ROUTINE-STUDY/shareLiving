package com.routinestudy.shareliving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinestudy.shareliving.repository.MemberRepository;
import com.routinestudy.shareliving.dto.MemberDto;
import com.routinestudy.shareliving.domain.Member;

@Service
public class MemberService {
  @Autowired
  private MemberRepository repository;

  public void signUp(String name, int age) throws IllegalArgumentException {
    Member member = new Member(name, age, false);
    repository.save(member);
  }

  public MemberDto getMember(long id) {
    Member user = repository.getReferenceById(id);
    MemberDto userDto = new MemberDto(user);

    return userDto;
  }
}
