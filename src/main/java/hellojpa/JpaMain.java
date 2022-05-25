package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 1
            List<Member> result1 = em.createQuery(
                "select m From Member m where m.username like '%kim%'",
                Member.class
            ).getResultList();

            // 2 Criteria
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);
            Root<Member> m = query.from(Member.class);
            CriteriaQuery<Member> cq = query.select(m);

            String userName = "abcd";
            if(userName != null) {
                cq = cq.where(cb.equal(m.get("userName"), "kim"));
            }

            List<Member> result2 = em.createQuery(cq).getResultList();

            // 3 QueryDSL
            // JPQL Builder

            // 4 Native SQL
           em.createNativeQuery(
                "select MEMBER_ID, city, street, zipcode from MEMBER").getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();

    }

}
