package com.routinestudy.shareliving.repository;

import com.routinestudy.shareliving.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {

    List<Member> findByUsername(String username);
}
