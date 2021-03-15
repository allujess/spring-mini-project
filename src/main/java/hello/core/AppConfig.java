package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    //이전에는 객체를 성하고 구현할 것을 직접정함
    public MemberService memberService(){
        //new MemoryMemberRepository객체를 생성해서 참조값을 넣어줌
        return new MemberServiceImpl(memberRepository());
        }
    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        //파라미터로 들어가는데 주입해준다고 표현함 injection
        return new OrderServiceImpl(memberRepository(),  discountPolicy());

        }
        @Bean
        public DiscountPolicy discountPolicy(){
       //return new FixDiscountPolicy();
            return new RateDiscountPolicy();

        }
}
