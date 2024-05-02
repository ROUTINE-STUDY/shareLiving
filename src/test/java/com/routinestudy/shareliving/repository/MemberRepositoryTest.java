package com.routinestudy.shareliving.repository;

import com.routinestudy.shareliving.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 사용자명_ID로_회원조회() {
        // 테스트용 멤버 생성
        Member member = Member.builder().username("testUser").password("testPassword").nickname("testNickname").build();

        // 멤버 저장
        memberRepository.save(member);

        // findByUsername 메서드로 멤버 조회
        List<Member> foundMembers = memberRepository.findByUsername("testUser");

        // 조회된 멤버 확인
        assertEquals(1, foundMembers.size()); // 결과가 1개여야 함
        Member foundMember = foundMembers.get(0);
        assertEquals("testUser", foundMember.getUsername()); // 사용자명 일치 확인
        assertEquals("testPassword", foundMember.getPassword()); // 비밀번호 일치 확인
        assertEquals("testNickname", foundMember.getNickname()); // 닉네임 일치 확인
    }

}