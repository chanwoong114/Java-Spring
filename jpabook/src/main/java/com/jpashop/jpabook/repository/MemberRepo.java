package com.jpashop.jpabook.repository;

import com.jpashop.jpabook.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member,Long> {

     Member findMemberByName(String name);

}
