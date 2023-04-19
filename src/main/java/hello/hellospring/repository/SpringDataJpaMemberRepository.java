package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //<클래스, id의 데이터타입>

    //JPQL select m from Member m where m.name = ?
    //인터페이스 이름만으로 개발이 끝난다
    @Override
    Optional<Member> findByName(String name); //표준으로 만들 수 없는 기능
//    Optional<Member> findByNameAndId(String name, Long Id);

    //JPA가 자동으로 구현체를 만들어준다
}
