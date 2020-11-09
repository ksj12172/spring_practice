package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    // 연관관계의 주인인 order table이 해당 테이블을 뭐라고 지칭하나
    @OneToOne(mappedBy="delivery")
    // 자바에서 delivery의 order를 부르고 싶을 때
    // 실제 sql에서는 order에서 해당 deliver id로 찾는다?
    private Order order;

    @Embedded
    // CITY, STREET, ZIPCODE 들어간다
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
