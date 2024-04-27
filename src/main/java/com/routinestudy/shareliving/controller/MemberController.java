package com.routinestudy.shareliving.controller;

import com.routinestudy.shareliving.dto.MemberSignUpRequestDto;
import com.routinestudy.shareliving.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("members/join")
    public ResponseEntity<?> joinMember(@Valid @RequestBody MemberSignUpRequestDto memberSignUpRequestDto) {
        memberService.signUp(memberSignUpRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
