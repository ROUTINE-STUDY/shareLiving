package com.routinestudy.shareliving.common;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice // 스프링 부트 애플리케이션에서 전역적으로 예외를 핸들링할 수 있게 해주는 어노테이션
public class ExceptionControllerAdvice {

    @AllArgsConstructor
    @NoArgsConstructor
    @Setter @Getter
    static class ErrorResponse {
        private Error error;

        @AllArgsConstructor
        @NoArgsConstructor
        static class Builder {
            private ErrorCode errorCode;
            private String errorMessage;

            public Builder errorCode(ErrorCode errorCode) {
                this.errorCode = errorCode;
                this.errorMessage = errorCode.getMessage();
                return this;
            }

            public Builder errorMessage(String errorMessage) {
                this.errorMessage = errorMessage;
                return this;
            }

            public ErrorResponse build() {
                return new ErrorResponse(new Error(errorCode, errorMessage));
            }
        }
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .errorCode(e.getErrorCode())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException e) {
        StringBuilder errorMessage = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach((error) -> errorMessage.append(error.getDefaultMessage()).append("[").append(((FieldError) error).getField()).append("]"));

        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .errorCode(ErrorCode.UNREGISTERED_EXCEPTION)
                .errorMessage(errorMessage.toString())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse.Builder().errorCode(ErrorCode.INVALID_PARAMETER).errorMessage(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}