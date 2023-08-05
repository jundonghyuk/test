package com.test.database.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    public static int cnt = 0;
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional(readOnly = true)
    public Long findMember(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        cnt++;
        if (cnt % 2 != 0) {
            Thread.sleep(30000);
        }
        return member.get().getId();
    }

    @Transactional
    public void update(Request request) throws Exception {
        Member member = memberRepository.findById(request.getId()).get();
        member.setName(request.getName());
        if (cnt % 2 != 0) {
            Thread.sleep(30000);
        }
    }
}
