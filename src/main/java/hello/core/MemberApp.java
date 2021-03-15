package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

     //   AppConfig appConfig = new AppConfig();
        //memberService인터페이스를 줌 여기안에는 memberServiceImpl이 들어있음
       // MemberService memberService = appConfig.memberService();

        //spring 생성
        //appConfig환경설정을 가지고 spring이 각 @bean이된걸르 컨테이너에 객체생성해서 관리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        //  MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member : " + member.getName());
        System.out.println("find member : " + findMember.getName());

    }
}
