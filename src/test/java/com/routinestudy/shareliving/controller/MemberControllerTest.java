package com.routinestudy.shareliving.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.routinestudy.shareliving.dto.MemberSignUpRequestDto;
import com.routinestudy.shareliving.service.MemberService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @Test
    public void 회원가입_API_테스트() throws Exception {
        // 유효한 MemberSignUpRequestDto 생성
        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .username("validUsername")
                .password("validPassword")
                .nickname("validNickname")
                .build();

        // API 호출 및 응답 상태 코드 확인
        mockMvc.perform(post("/members/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void 회원가입_단위_테스트() throws Exception {
        // 유효한 MemberSignUpRequestDto 생성
        MemberSignUpRequestDto requestDto = MemberSignUpRequestDto.builder()
                .username("validUsername")
                .password("validPassword")
                .nickname("validNickname")
                .build();

        // memberService.signUp 메서드가 호출될 때 기대 동작 설정
        doNothing().when(memberService).signUp(any(MemberSignUpRequestDto.class));

        // joinMember 메서드 호출
        ResponseEntity<?> response = memberController.joinMember(requestDto);

        // 기대한 HTTP 응답 상태 코드인지 확인
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // memberService.signUp 메서드가 1회 호출되었는지 확인
        verify(memberService, times(1)).signUp(any(MemberSignUpRequestDto.class));
    }

}