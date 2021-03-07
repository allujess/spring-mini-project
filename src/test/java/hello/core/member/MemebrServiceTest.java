package hello.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemebrServiceTest {


    //DIP위베 : MemberServiceImpl구현체까지 의존하는것을 볼 수 있다
    //memberService interface의존은 ok
    MemberService memberService = new MemberServiceImpl();


    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        //then
        //member는 findMember는 똑같냐
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
    }
}
