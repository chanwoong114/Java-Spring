package com.jpashop.jpabook.apiService;

import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.dto.MemberRequest;
import com.jpashop.jpabook.dto.MemberResponse;
import com.jpashop.jpabook.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberApiService {

    private final MemberRepo memberRepo;

    @Transactional
    public MemberResponse join(MemberRequest memberRequest) {
//        Member member = memberRequest.toMember();
//        Member save = memberRepo.save(member);

        // 위와 아래는 같은 결과
        Member save = memberRepo.save(memberRequest.toMember());

        return new MemberResponse(save);

    }

    public MemberResponse memberDetail(Long id) {
        return new MemberResponse(memberRepo.findById(id).orElseThrow());
    }
}
