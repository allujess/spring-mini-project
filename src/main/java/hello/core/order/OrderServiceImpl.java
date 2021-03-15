package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

    //orderService는 2개가 필요함
    public final MemberRepository memberRepository ;
    public final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // ===========================================================
    //인터페이스만 의존하게한는거 / 구체에 의존하지않고 인터페이스에만 의존하게 하는것이당
    // // ========================================================
   // private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //회원정보를 정책하고
        Member member = memberRepository.findById(memberId);
        //할인 정책에 회원을 넘기는거임
        //단일체계원칙이 잘 된 경우
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //order반환 id, name, price, discountPrice를 반환

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
