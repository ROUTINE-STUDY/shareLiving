package com.routinestudy.shareliving.service;

import com.routinestudy.shareliving.domain.Member;
import com.routinestudy.shareliving.dto.MemberSignUpRequestDto;
import com.routinestudy.shareliving.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(rollbackFor = Exception.class) // FIXME : pointcut?
    public void signUp(MemberSignUpRequestDto memberSignUpRequestDto) {
        Member member = memberSignUpRequestDto.toEntity();

        List<Member> findMembers = memberRepository.findByUsername(member.getUsername());
        if (findMembers.size() > 0) {
            throw new IllegalArgumentException("중복된 아이디 입니다.");
        }

        memberRepository.save(member);
    }
}
