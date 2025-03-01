package com.routinestudy.shareliving.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import com.routinestudy.shareliving.domain.Member;
import com.routinestudy.shareliving.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 별다른 설정 없이 사용할 경우 H2 데이터베이스를 자동 실행
class MemberRepositoryTest {
  @Autowired
  private MemberRepository userRepository;

  // @Test
  // public void H2_연결_테스트() {
  // userRepository.save(new Member("name", 14, true));
  //
  // // when
  // int count = userRepository.findAll().size();
  // // then
  // assertEquals(1, count);
  // }
  //
  // @Test
  // public void whenInsertTwoMemberAndSelectAllThenFindAllSizeIsTwo() {
  // userRepository.save(new Member("sang", 20, true));
  //
  // Member member = userRepository.findByName("sang");
  // assertEquals("sang", member.getName());
  // }
}
