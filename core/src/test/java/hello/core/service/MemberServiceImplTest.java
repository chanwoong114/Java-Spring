package hello.core.service;

import hello.core.AppConfig;
import hello.core.domain.Grade;
import hello.core.domain.Member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){ // 미리 한번 해놓으면 나중에 할필요 없음
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

}