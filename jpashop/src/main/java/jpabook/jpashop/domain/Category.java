package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name="category_id")
    private Long id;

    private String name;

    // 실무에서는 사용하지 말자
    // 중간 테이블에 칼럼을 추가할수도 없고, 세밀하게 쿼리를 실행하기 어렵다.
    // 중간 entity를 만들고 @ManyToOne, @OneToMany로 매핑해서 사용하자
    @ManyToMany
    // annotation으로 적을 때는 db에 적히는 이름대로 적는구나
    // 그냥 테이블 칼럼 설정해주는거?
    @JoinTable(name="category_item",
        joinColumns=@JoinColumn(name="category_id"),
        inverseJoinColumns = @JoinColumn(name="item_id")
    ) // 중간테이블 매핑
    // 관계형 db는 객체처럼 collection과 collection을 가질 수 없다. 중간테이블이 필요하다
    // 실전에서 쓰지 마라. 필드를 더 추가하지 못한다. 실무에서는 다른 필드도 넣어줘야 한다.
    private List<Item> items = new ArrayList<>();

    // self로 양방향 연관관계 맺기
    @ManyToOne
    @JoinColumn(name="parent_id") // 하위 카테고리가 또 있는건가
    private Category parent;

    @OneToMany(mappedBy="parent")
    private List<Category> child = new ArrayList<>();
}
