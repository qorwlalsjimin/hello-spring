package hello.hellospring.domain;

import javax.persistence.*;

@Entity //JPA가 관리하는 Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY: DB가 알아서 생성해주는 값
    private Long id; //시스템에서 사용자를 식별하기 위해 지정

    @Column(name = "name")
    private String name; //사용자 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
