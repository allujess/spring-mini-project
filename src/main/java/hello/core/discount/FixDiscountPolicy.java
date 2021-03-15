package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    public int discountFixAmount = 1000; //1000원 할인


    @Override
    public int discount(Member member, int price) {

        //VIP일때
        if(member.getGrade() == Grade.VIP){

            //vip면 위에있는 전역변수 1000원 할인 아니면 짤
            return discountFixAmount;
            }else{
                return 0;
            }
        }
    }
