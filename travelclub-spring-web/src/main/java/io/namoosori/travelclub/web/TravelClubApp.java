package io.namoosori.travelclub.web;

import io.namoosori.travelclub.web.aggregate.club.CommunityMember;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import io.namoosori.travelclub.web.service.ClubService;
import io.namoosori.travelclub.web.service.MemberService;
import io.namoosori.travelclub.web.service.logic.MemberServiceLogic;
import io.namoosori.travelclub.web.service.sdo.MemberCdo;
import io.namoosori.travelclub.web.service.sdo.TravelClubCdo;
import io.namoosori.travelclub.web.shared.NameValueList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class TravelClubApp {

    public static void testDI(ApplicationContext context) {
////        DI setting using xml file
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String [] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));

        System.out.println("Get Foo bean from context");
        Foo foo = context.getBean("foo", Foo.class);
        System.out.println("Get Bar bean from context");
        Bar bar = context.getBean("bar", Bar.class);
        foo.setBar(bar);
        foo.say();

        FooOrg fooOrg = new FooOrg();
        fooOrg.say();
    }


    public static void testTravelClub(ApplicationContext context) {

        // service name - start with lower case
        TravelClubCdo clubCdo = new TravelClubCdo("TrvelClub", "Test TravelClub");
        ClubService  clubService = context.getBean("clubService",ClubService.class);

        String clubId = clubService.registerClub(clubCdo);

        System.out.println("ID : " + clubId);

        TravelClub foundedClub = clubService.findClubById(clubId);
        System.out.println("Club name : " + foundedClub.getName());
        System.out.println("Club intro : " + foundedClub.getIntro());
//        System.out.println("Club foundationTime : " + foundedClub.getFoundationTime());
        System.out.println("Club foundationTime : " + new Date(foundedClub.getFoundationTime()));

        MemberService   memberService = context.getBean("memberServiceLogic", MemberServiceLogic.class);

        String memberId = memberService.registerMember(
                new MemberCdo(
                        "jonpark@synopsys.com",
                        "Ryan",
                        "Test Member",
                        "010-123-4567",
                        "1975.01.01" ));


        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());
    }

    public static void testTravelClubAll(ApplicationContext context){
        // 등록된 빈 정보 확인하기
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));   // [clubStore, clubService]

        System.out.println();
        System.out.println(" -----  1. travelclub  register  ------- ");

        TravelClubCdo clubCdo = new TravelClubCdo("TravelClub", "Test TravelClub");
        ClubService clubService = context.getBean("clubService", ClubService.class);

        String clubId = clubService.registerClub(clubCdo);
        System.out.println("Club id : " + clubId);

        TravelClub foundedClub = clubService.findClubById(clubId);

        System.out.println("Club name : " + foundedClub.getName());
        System.out.println("Club intro : " + foundedClub.getIntro());
        System.out.println("Club foundationTime : " + new Date(foundedClub.getFoundationTime()));
        System.out.println("Club id : " + foundedClub.getId());

        System.out.println();
        System.out.println(" -----  2. travelclub modify  result  ------- ");

        NameValueList nameValues = new NameValueList();
        nameValues.addNameValue("name","healing-club");
        nameValues.addNameValue("intro","healing club intro");
        clubService.modify(foundedClub.getId(), nameValues);

        System.out.println("Club name : " + foundedClub.getName());
        System.out.println("Club intro : " + foundedClub.getIntro());
        System.out.println("Club foundationTime : " + new Date(foundedClub.getFoundationTime()));
        System.out.println("Club id : " + foundedClub.getId());

        System.out.println();
        System.out.println(" -----  3. member register & find  ------- ");

        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);

        String memberId = memberService.registerMember(
                new MemberCdo(
                        "test@poscoict.com",
                        "Hwang",
                        "Team Member",
                        "010-111-2222",
                        "2010.10.10"));

        CommunityMember foundedMember = memberService.findMemberById(memberId);
        System.out.println(foundedMember.toString());
    }

    public static void main(String[] args) {
        /////////////// unit test - DI setting using xml file
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        TravelClubApp.testDI(context);
//        TravelClubApp.testTravelClub(context);
//        TravelClubApp.testTravelClubAll(context);
//        if(true)
//            return;


        ///////////////// start spring application
        SpringApplication.run(TravelClubApp.class);
    }
}
