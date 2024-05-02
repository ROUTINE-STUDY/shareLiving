package com.routinestudy.shareliving.common;

import lombok.Getter;

@Getter
class Error {

    private final String code;
    private final String message;

    public Error(ErrorCode errorCode, String message) {
        this.code = errorCode.getCode();
        this.message = message;
    }
}