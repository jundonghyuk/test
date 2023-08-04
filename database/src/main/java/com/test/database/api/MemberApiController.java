package com.test.database.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    public final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/get")
    public ResponseEntity<Long> findMember() throws Exception{
        Long member = memberService.findMember();
        return ResponseEntity.ok(member);
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<Long> updateMember(@PathVariable Long id) throws Exception {
        memberService.update(id);
        return ResponseEntity.ok().build();
    }
}
