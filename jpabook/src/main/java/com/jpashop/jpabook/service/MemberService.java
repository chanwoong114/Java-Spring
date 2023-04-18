package com.jpashop.jpabook.service;

import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // 필수생성자 lombok에서 알아서 생성
public class MemberService {

    private final MemberRepo memberRepo;

    @Transactional //변경
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepo.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMember = memberRepo.findMemberByName(member.getName());

        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMember() {
        return memberRepo.findAll();
    }
    public Member findOne(Long memberId) {
        return memberRepo.findById(memberId).get();
    }
}
