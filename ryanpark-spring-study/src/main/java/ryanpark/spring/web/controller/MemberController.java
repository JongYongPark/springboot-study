package ryanpark.spring.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ryanpark.spring.web.aggregate.club.CommunityMember;
import ryanpark.spring.web.service.MemberService;
import ryanpark.spring.web.service.sdo.MemberCdo;
import ryanpark.spring.web.shared.NameValueList;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public String register(@RequestBody MemberCdo memberCdo) {
        return memberService.registerMember(memberCdo);
    }

    @GetMapping
    public CommunityMember findByIdOrEmail(@RequestParam String memberId, @RequestParam String memberEmail) {
        if (!memberId.equals("")) {
            return memberService.findMemberById(memberId);
        }

        return memberService.findMemberByEmail(memberEmail);
    }

    @GetMapping("/{name}")
    public List<CommunityMember> findByName(@PathVariable String name) {
        return memberService.findMembersByName(name);
    }

    @PutMapping("/{memberId}")
    public void modify(@PathVariable String memberId, @RequestBody NameValueList nameValueList) {
        memberService.modifyMember(memberId, nameValueList);
    }

    @DeleteMapping("/{memberId}")
    public void delete(@PathVariable String memberId) {
        memberService.removeMember(memberId);
    }
}
