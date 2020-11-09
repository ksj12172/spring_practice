package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.domain.item.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 상속관계 전략을 부모 테이블에 잡아줘야 한다
// 여기서는 single table 전략 쓸
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    // 상대 테이블에서 나를 뭐라고 부르나
    @ManyToMany(mappedBy="items")
    private List<Category> categories = new ArrayList<>();
}
