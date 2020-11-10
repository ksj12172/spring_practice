package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    // 어떤 테이블인지 아는 것은 class보고?
    // 아니면 name에 적는 field 이름만 적고?(그럼 이름 같으면 안되겠네)
    // 자동으로 타입? 클래스로 적어주는 객체의 id?
    // JoinColumn에 적어주는 값은 테이블에 적어주는 이름?!
    // field 이름이 member_id가 아니라 그냥 member구나
    @ManyToOne(fetch=FetchType.EAGER) // 즉시로딩?
    //ManyToOne, OneToOne은 EAGER, OneToMany는 LAZY
    // JPQL select * from order o; -> 할 때 위험, n+1위험(쿼리 결과 개수:member 가져와야 해서 + select쿼리)
    @JoinColumn(name="member_id") // foreign key
    // 연관관계주인 정하기 : 한 곳만 바꿀 수 있도, foreign key값을 누가 업데이트하냐
    // 객체는 변경 포인트가 두 군데인데 테이블은 foreign key만, 바꿀 수 있는게 연관관계 주인
    private Member member;

    // 내가 연관관계의 주인이 아니라면 테이블에 해당 필드가 나오지 않는다.
    @OneToMany(mappedBy="order") // 내가 뭐라고 불리는지?(클래스에서)
    private List<OrderItem> orderItems = new ArrayList();

    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    // 시간 분까지, JAVA8 가능, hibernate가 알아서 매핑해준다
    // 테이블에 자동으로 ORDER_DATE라고 들어가는군
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
