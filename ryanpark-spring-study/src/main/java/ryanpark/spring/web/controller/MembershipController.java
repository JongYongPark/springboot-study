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

import ryanpark.spring.web.aggregate.club.Membership;
import ryanpark.spring.web.service.MembershipService;
import ryanpark.spring.web.service.sdo.MembershipCdo;
import ryanpark.spring.web.shared.NameValue;
import ryanpark.spring.web.shared.NameValueList;

@RestController
@RequestMapping("membership")
public class MembershipController {
    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PostMapping
    public String register(@RequestBody MembershipCdo membershipCdo) {
        return membershipService.registerMembership(membershipCdo);
    }

    @GetMapping("/{membershipId}")
    public Membership findById(@PathVariable String membershipId) {
        return membershipService.findMembership(membershipId);
    }

    @GetMapping("/find/{clubId}")
    public Membership findByClubIdAndMemberId(@PathVariable String clubId, @RequestParam String memberId, @RequestParam String memberEmail){
        if (!memberId.isBlank()) {
            return membershipService.findMembershipByClubIdAndMemberId(clubId, memberId);
        }

        return membershipService.findMembershipByClubIdAndMemberEmail(clubId, memberEmail);
    }

    @PostMapping("/find/all")
    public List<Membership> findAllOfClub(@RequestBody NameValueList nameValueList) {
        for (NameValue nameValue : nameValueList.getNameValues()) {
            String findKey = nameValue.getName();
            if (findKey.equals("clubId")) {
                return membershipService.findAllMembershipsOfClub(nameValue.getValue());
            }

            if (findKey.equals("memberId")) {
                return membershipService.findAllMembershipsOfMember(nameValue.getValue());
            }
        }

        return null;
    }

    @PutMapping
    public void modify(@PathVariable String membershipId, @RequestBody NameValueList nameValueList) {
        membershipService.modifyMembership(membershipId, nameValueList);
    }

    @DeleteMapping
    public void delete(@PathVariable String membershipId) {
        membershipService.removeMembership(membershipId);
    }
}
