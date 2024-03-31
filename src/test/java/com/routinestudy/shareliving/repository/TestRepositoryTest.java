package com.routinestudy.shareliving.repository;

import com.routinestudy.shareliving.domain.Hello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest                 // 별다른 설정 없이 사용할 경우 H2 데이터베이스를 자동 실행
class TestRepositoryTest {
    @Autowired
    private TestRepository testRepository;

    @Test
    public void H2_연결_테스트() {
        // give
        testRepository.save(new Hello(1, "인규"));
        testRepository.save(new Hello(2, "상후"));

        // when
        List<Hello> all = testRepository.findAll();

        // then
        assertEquals(2, all.size());
    }
}