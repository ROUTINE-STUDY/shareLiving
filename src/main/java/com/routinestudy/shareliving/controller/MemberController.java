package com.routinestudy.shareliving.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinestudy.shareliving.dto.MemberDto;
import com.routinestudy.shareliving.service.MemberService;

@RestController
public class MemberController {
  @Autowired
  MemberService mService;

  private static Logger logger = Logger.getLogger("TestController");

  @RequestMapping("/config")
  public String home() {
    logger.log(Level.CONFIG, "Config log");
    return "home";
  }

  @GetMapping("/info")
  public String findById() {
    logger.log(Level.INFO, "INFO log");
    return "";
  }

  @GetMapping("/warn")
  public ResponseEntity<MemberDto> findById2() {
    ResponseEntity<MemberDto> res = new ResponseEntity<MemberDto>(new MemberDto(), HttpStatus.NOT_FOUND);
    logger.log(Level.WARNING, "Warning log");
    return res;
  }

  @PostMapping("/users/sign-up")
  public Map<String, String> signUp(String name, int age) {
    Map<String, String> map = new HashMap<>();
    try {
      mService.signUp(name, age);
    } catch (IllegalArgumentException e) {
      logger.log(Level.WARNING, "SignUp Failed with name: " + name + ", age: " + age);
      map.put("status", "404");
    }
    map.put("status", "200");

    return map;
  }

  @GetMapping("/users/{userNo}")
  public ResponseEntity<MemberDto> getUser(@PathVariable long userNo) {
    MemberDto member;
    try {
      member = mService.getMember(userNo);
    } catch (IllegalArgumentException e) {
      logger.log(Level.WARNING, "getUser Failed with userNo:" + userNo);
      return new ResponseEntity<MemberDto>(HttpStatusCode.valueOf(400));
    }

    return new ResponseEntity<MemberDto>(member, HttpStatusCode.valueOf(200));
  }
}
