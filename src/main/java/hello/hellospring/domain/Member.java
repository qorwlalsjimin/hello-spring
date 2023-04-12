package hello.hellospring.domain;

public class Member {
    private Long id; //시스템에서 사용자를 식별하기 위해 지정
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
