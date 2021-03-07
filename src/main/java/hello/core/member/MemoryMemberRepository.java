package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //저장소니깐 map필요
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(),  member);
    }

    @Override
    public Member findById(Long memberId) {
        //findById하면 get해서 memberId찾는거임
        return store.get(memberId);
    }
}
