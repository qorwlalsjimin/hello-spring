package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

//구현체
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); //Key, Member
    private static long sequence = 0L; //key값 생성해줌

    @Override
    public Member save(Member member) { //정보 저장
        member.setId(++sequence); //sequence에 1 올려서 아이디 지정
        store.put(member.getId(), member); //Map에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null일 수도 있어서 ofNullable로 감쌈
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //store 값에서
                .filter(member -> member.getName().equals(name)) //name과 똑같은 값만 남김
                .findAny(); //데이터 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //데이터 리스트로 반환
    }
}
