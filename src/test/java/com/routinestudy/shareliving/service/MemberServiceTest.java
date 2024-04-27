package com.routinestudy.shareliving.service;

import com.routinestudy.shareliving.domain.Member;
import com.routinestudy.shareliving.dto.MemberSignUpRequestDto;
import com.routinestudy.shareliving.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void 회원가입_정상_테스트() {
        // Mock 객체 초기화
        MockitoAnnotations.openMocks(this);

        // 빌더 패턴을 사용하여 테스트용 MemberSignUpRequestDto 생성
        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .username("uniqueUsername")
                .password("testPassword")
                .nickname("testNickname")
                .build();

        // findByUsername 메서드가 빈 리스트 반환하도록 설정
        when(memberRepository.findByUsername(anyString())).thenReturn(new ArrayList<>());

        // signUp 메서드 호출
        memberService.signUp(requestDto);

        // findByUsername 메서드가 호출되었는지 확인
        verify(memberRepository, times(1)).findByUsername("uniqueUsername");

        // save 메서드가 호출되었는지 확인
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    @Test
    public void 중복된_회원가입_테스트() {
        // Mock 객체 초기화
        MockitoAnnotations.openMocks(this);

        // 빌더 패턴을 사용하여 테스트용 MemberSignUpRequestDto 생성
        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .username("duplicateUsername")
                .password("testPassword")
                .nickname("testNickname")
                .build();

        // findByUsername 메서드가 이미 존재하는 멤버를 반환하도록 설정
        List<Member> existingMembers = new ArrayList<>();
        existingMembers.add(new Member());
        when(memberRepository.findByUsername(anyString())).thenReturn(existingMembers);

        // signUp 메서드 호출 시 IllegalArgumentException 예외가 발생하는지 확인
        assertThrows(IllegalArgumentException.class, () -> memberService.signUp(requestDto));

        // findByUsername 메서드가 호출되었는지 확인
        verify(memberRepository, times(1)).findByUsername("duplicateUsername");

        // save 메서드가 호출되지 않았는지 확인
        verify(memberRepository, never()).save(any(Member.class));
    }

}