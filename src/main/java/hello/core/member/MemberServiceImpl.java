package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //join을해서 다형성에 의해서  save호출하면 memoryMemberRepository있는 save() 오버라이드가 호출

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
