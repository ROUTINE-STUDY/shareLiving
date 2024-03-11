package com.routinestudy.shareliving.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String home() {
        System.out.println("231232321");
        return "home";
    }

    @GetMapping("/test")
    public PostsResponseDto findById() {
        System.out.println(123);
        return new PostsResponseDto();
    }

    @GetMapping("/test2")
    public ResponseEntity<PostsResponseDto> findById2() {
        System.out.println(123);
        ResponseEntity<PostsResponseDto> res = new ResponseEntity<PostsResponseDto>(new PostsResponseDto(), HttpStatus.NOT_FOUND);
        return res;
    }

    class CommonSt {
        String status; // fail skip valid
        String msg; // 저장 실패, 이름이 중복됌
    }
    class PostsResponseDto  {
        String name = "123";

        public String getName() {
            return name;
        }
    }

}
