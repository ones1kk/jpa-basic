package hellojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            // Update
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
//                .setFirstResult(5)
//                .setMaxResults(8)
//                .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            System.out.println("BEFORE");
//            // 영속 : 엔티티를 영속
//            em.persist(member);
//            System.out.println("AFTER");
//
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            System.out.println("findMember1 == findMember2 : " + (findMember1 == findMember2)) ;

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("===========================");

//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("ZZZZZZ");

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush();

            // 준영속 상태로 전환
//            em.detach(findMember);

            // 영속성 컨테스트 초기화
//            em.clear();

            // 영속성 컨테스트 종료
//            em.close();

//            Member member = new Member();
//            member.setId(3L);
//            member.setUsername("C");
//            member.setRoleType(RoleType.GUEST);

//            Member member = new Member();
//            member.setUsername("C");
//
//            em.persist(member);

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> findMembers = findMember.getTeam().getMembers();
//
//            for (Member findMember1 : findMembers) {
//                System.out.println("findMember1 = " + findMember1);
//            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();

    }

}
