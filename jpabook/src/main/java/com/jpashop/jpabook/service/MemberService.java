package com.jpashop.jpabook.service;

import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;

    public Member findMember(Long memberId){
        Optional<Member> member = memberRepo.findById(memberId);
        return member.get();
    }
}
