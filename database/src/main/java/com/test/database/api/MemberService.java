package com.test.database.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    public static int cnt = 0;
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Long findMember() throws Exception {
        List<Member> all = memberRepository.findAll();
        cnt++;
        if (cnt % 2 != 0) {
            Thread.sleep(60000);
        }
        return all.get(0).getId();
    }

    @Transactional
    public void update(Long id) throws Exception {
        Member member = memberRepository.findById(id).get();
        member.setName("하디");
        if (cnt % 2 != 0) {
            Thread.sleep(60000);
        }
    }
}
