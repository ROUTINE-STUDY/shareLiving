package com.routinestudy.shareliving.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.routinestudy.shareliving.dto.MemberDto;

@RestController
public class MemberController {

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
}
