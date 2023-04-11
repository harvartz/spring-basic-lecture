package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {/*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService()*/;

        //AppConfig에 있는 환경 설정 정보를 가지고 Spring이 Spring컨테이너에 알아서 객체 생성해서 관리
        //예전에는 직접 찾아왔지만 지금은 컨테이너에 알아서
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
