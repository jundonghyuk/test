package com.test.database.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberApiController {

    public final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/get")
    public ResponseEntity<MemberDto> findMember(@RequestParam Long id) throws Exception{
        MemberDto member = memberService.findMember(id);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/post")
    public ResponseEntity<Long> updateMember(@RequestBody Request request) throws Exception {
        memberService.update(request);
        return ResponseEntity.ok().build();
    }
}
