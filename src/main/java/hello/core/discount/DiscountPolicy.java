package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //discount 파라미터로 member, price를 넘김
    //return 이 할인 대상 금액
    int discount(Member member, int price);


}
