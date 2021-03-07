package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService{

    //orderService는 2개가 필요함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


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
