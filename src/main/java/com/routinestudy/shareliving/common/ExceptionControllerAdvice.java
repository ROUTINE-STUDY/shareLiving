package com.routinestudy.shareliving.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
        private String message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            errorResponse.setMessage(error.getDefaultMessage() + "[" + ((FieldError) error).getField() + "]");
        });

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}