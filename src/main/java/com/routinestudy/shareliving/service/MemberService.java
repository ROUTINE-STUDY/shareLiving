package com.routinestudy.shareliving.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.routinestudy.shareliving.repository.MemberRepository;
import com.routinestudy.shareliving.dto.MemberDto;
import com.routinestudy.shareliving.domain.Member;

@Service
public class MemberService {
  Logger logger = LoggerFactory.getLogger(MemberService.class.getSimpleName());

  @Autowired
  private MemberRepository repository;

  public void signUp(String name, int age) throws IllegalArgumentException {
    logger.debug("name: " + name + " age: " + age);
    Member member = new Member(name, age, false);
    logger.debug("member: " + member);

    repository.save(member);
  }

  public MemberDto getMemberByName(String name) {
    Member member = repository.findByName(name);
    MemberDto memberDto = new MemberDto(member);

    return memberDto;
  }
}
