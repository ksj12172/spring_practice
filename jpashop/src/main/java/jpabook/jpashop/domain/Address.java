package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // JPA spec상 엔티티나 임베디드타입은 public or protected로 설정해야 한다, 더 안전한 protected 사용
    // 객체 생성, 프록시 같은거 쓸 때 리플렉션 같은 기술 사용하기 위해 있는 제약이다
    protected Address() {
    }

    // setter를 제거하고 생성자에서 값을 모두 초기화해서 변경이 불가능한 클래스를 만들자.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
