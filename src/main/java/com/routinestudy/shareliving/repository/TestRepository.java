package com.routinestudy.shareliving.repository;

import com.routinestudy.shareliving.domain.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Hello, Long> {

}
