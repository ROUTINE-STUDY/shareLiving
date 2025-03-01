package com.routinestudy.shareliving.repository;

import com.routinestudy.shareliving.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  public Member findByName(String name);
}
