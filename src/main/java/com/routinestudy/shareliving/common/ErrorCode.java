package com.routinestudy.shareliving.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    // 등록되지 않은 예외
    UNREGISTERED_EXCEPTION("s-00000", "CustomException이 아닙니다."),

    // 회원 관련 도메인 예외
    ALREADY_REGISTERED("s-10000", "이미 존재하는 회원입니다."),

    //400 BAD_REQUEST 잘못된 예외
    INVALID_PARAMETER("s-40000", "파라미터 값을 확인해주세요."),
    NOT_FOUND_EXCEPTION("s-40001", "파라미터 값을 확인해주세요.");

    private final String code;
    private final String message;
}