package com.jpashop.jpabook.repository;

import com.jpashop.jpabook.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member,Long> {

     List<Member> findMemberByName(String name);

}
