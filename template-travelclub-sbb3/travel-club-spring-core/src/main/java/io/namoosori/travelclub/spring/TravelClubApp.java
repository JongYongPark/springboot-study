package io.namoosori.travelclub.spring;

import java.util.Arrays;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.spring.shared.NameValueList;

// applicationContext.xml에서 등록한 bean을 테스트를 위해서 만드는 main 메서드를 가지고 있는 클래스
public class TravelClubApp {
    
     public static void main(String[] args) {
         // 같은 context path 안에 applicationContext.xml에 있다는 것을 알려줌
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //String [] beanNames = context.getBeanDefinitionNames();
        //System.out.println(Arrays.toString(beanNames)); // [clubStore, clubService]

        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
        ClubService clubService = context.getBean("clubService", ClubService.class);
        MemberService memberService = context.getBean("memberService", MemberService.class);

        String clubId = clubService.registerClub(clubCdo);
        TravelClub foundedClub = clubService.findClubById(clubId);

        System.out.println("foundedClub Name : " + foundedClub.getName());
        System.out.println("foundedClub Intro : " + foundedClub.getIntro());
        System.out.println("foundedClub foundationTime : " + new Date(foundedClub.getFoundationTime()));

        String memberId = memberService.registerMember(
            new MemberCdo("test@test.com", "SOOM", "TestMember", "010-1111-2222", "2022.11.21")
        );
        CommunityMember fCommunityMember = memberService.findMemberById(memberId);

        System.out.println("fCommunityMember email : " + fCommunityMember.getEmail());
        System.out.println("fCommunityMember name : " + fCommunityMember.getName());
        System.out.println("fCommunityMember nickName : " + fCommunityMember.getNickName());
        System.out.println("fCommunityMember phoneNumber : " + fCommunityMember.getPhoneNumber());
        System.out.println("fCommunityMember birthday : " + fCommunityMember.getBirthDay());
    }
}
