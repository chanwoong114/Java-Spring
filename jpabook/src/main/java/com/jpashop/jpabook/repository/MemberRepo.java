package com.jpashop.jpabook.repository;

import com.jpashop.jpabook.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member,Long> {

     List<Member> findMemberByName(String name);

     Optional<Member> findMemberByAddress(String name);

}
