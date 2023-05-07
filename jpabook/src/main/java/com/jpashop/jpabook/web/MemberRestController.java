package com.jpashop.jpabook.web;

import com.jpashop.jpabook.apiService.MemberApiService;
import com.jpashop.jpabook.domain.Member;
import com.jpashop.jpabook.dto.MemberRequest;
import com.jpashop.jpabook.dto.MemberResponse;
import com.jpashop.jpabook.repository.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberApiService memberApiService;

    private final MemberRepo memberRepo;

    @GetMapping("/member/{id}")
    public ResponseEntity<MemberResponse> detail(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(memberApiService.memberDetail(id));
    }

    @PostMapping("/joinMember")
    public ResponseEntity<MemberResponse> joinMember(@RequestBody MemberRequest memberRequest) {
        return ResponseEntity.ok().body(memberApiService.join(memberRequest));
    }


}
