package com.routinestudy.shareliving.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberSignUpRequestDtoTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void 아이디_입력_공백_유효성() {
        MemberSignUpRequestDto request = MemberSignUpRequestDto.builder()
                .password("password123")
                .nickname("nickname")
                .build();
        Set<ConstraintViolation<MemberSignUpRequestDto>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("아이디를 입력해주세요.", violations.iterator().next().getMessage());
    }

    @Test
    public void 아이디_길이_유효성() {
        MemberSignUpRequestDto request = MemberSignUpRequestDto.builder()
                .username("user")
                .password("password123")
                .nickname("nickname")
                .build();
        Set<ConstraintViolation<MemberSignUpRequestDto>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("아이디는 5~20자 이상입니다", violations.iterator().next().getMessage());
    }

    @Test
    public void 비밀번호_공백_유효성() {
        MemberSignUpRequestDto request = MemberSignUpRequestDto.builder()
                .username("username")
                .nickname("nickname")
                .build();
        Set<ConstraintViolation<MemberSignUpRequestDto>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("비밀번호를 입력해주세요.", violations.iterator().next().getMessage());
    }

    @Test
    public void 비밀번호_길이_유효성() {
        MemberSignUpRequestDto request = MemberSignUpRequestDto.builder()
                .username("username")
                .password("pass")
                .nickname("nickname")
                .build();
        Set<ConstraintViolation<MemberSignUpRequestDto>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("비밀번호는 8~16자 이상입니다", violations.iterator().next().getMessage());
    }

    @Test
    public void 닉네임_입력_유효성() {
        MemberSignUpRequestDto request = MemberSignUpRequestDto.builder()
                .username("username")
                .password("password123")
                .build();
        Set<ConstraintViolation<MemberSignUpRequestDto>> violations = validator.validate(request);
        assertEquals(1, violations.size());
        assertEquals("닉네임을 입력해주세요.", violations.iterator().next().getMessage());
    }
}