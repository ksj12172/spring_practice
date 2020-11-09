package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id") // 실무에서 편리하기 위해 foreign key와 같은 이름을 사용한다
    private Long id;
    private String name;
    @Embedded // 내장타입이
    // 나중에 table 보면 CITY, STREET, ZIPCODE
    private Address address;

    // 스프링에서 list 형태로 써준다
    // 나는 매핑된 거울이다. 읽기 전용
    // 값을 넣어도 foreign key 값이 변경되지 않는다.
    // 1,다 쪽 다 서로가 가진 대상 필드명을 적어주었구나
    // 연관관계의 주인이 이 entity를 뭐라고 이름지었나
    @OneToMany(mappedBy="member") // order table에 있는 member field
    // orders 테이블에서 member로 뽑아올 수 있고
    // java code에서는 바로 orders에 접근 가능?
    private List<Order> orders = new ArrayList<>();
}
