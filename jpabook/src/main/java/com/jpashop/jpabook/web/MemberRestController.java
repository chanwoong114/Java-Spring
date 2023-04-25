package com.jpashop.jpabook.web;

import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberRepo memberRepo;
    @GetMapping("/showMembers")
    public List<Member> showMembers() {
        List<Member> all = memberRepo.findAll();
        return all;
    }

    @PostMapping("/joinMember")
    public void joinMember(@RequestBody MemberForm memberForm) {
        Member member = new Member();

        member.setName(memberForm.getName());

        memberRepo.save(member);
    }
}
