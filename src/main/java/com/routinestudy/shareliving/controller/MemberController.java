package com.routinestudy.shareliving.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.routinestudy.shareliving.dto.MemberDto;
import com.routinestudy.shareliving.service.MemberService;

@RestController
public class MemberController {
  @Autowired
  MemberService mService;

  private static Logger logger = LoggerFactory.getLogger(MemberController.class.getSimpleName());

  @PostMapping("/users/sign-up")
  public Map<String, String> signUp(String name, int age) {
    logger.debug("name: " + name, " age: " + age);

    Map<String, String> map = new HashMap<>();
    try {
      mService.signUp(name, age);
    } catch (IllegalArgumentException e) {

      map.put("status", "404");
    }
    map.put("status", "200");

    return map;
  }

  @GetMapping("/users")
  public ResponseEntity<MemberDto> getUserByNo(@RequestParam(name = "name") String name) {
    MemberDto member;
    try {
      member = mService.getMemberByName(name);
    } catch (IllegalArgumentException e) {
      logger.error("Ivalid Argument Exception", e);
      return new ResponseEntity<MemberDto>(HttpStatusCode.valueOf(400));
    }

    return new ResponseEntity<MemberDto>(member, HttpStatusCode.valueOf(200));
  }
}
