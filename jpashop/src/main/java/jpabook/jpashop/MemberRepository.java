package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    // spring-boot-starter-data-jpa 등록하면서 boot가 알아서 생성해준
    // spring boot : spring container 안에서 모든 게 동작한다
    // spring boot가 다음 annotation이 있으면 entity manager에 주입해준다?
    // jpa : entity manager가 있어야 한다
    @PersistenceContext
    private EntityManager em;

    // command와 query를 분리한다
    // id는 반환하는 이유? 다음에 조회하기 위해
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
