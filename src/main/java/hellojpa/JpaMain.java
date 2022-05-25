package hellojpa;

import java.util.List;
import java.util.Set;
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
            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity", "street1", "zipcode1"));

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("pizza");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "zipcode1"));
            member.getAddressHistory().add(new AddressEntity("old2", "street1", "zipcode1"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("============== START ============== ");
            Member findMember = em.find(Member.class, member.getId());

            System.out.println("============== START ============== ");
            List<AddressEntity> addressHistory = findMember.getAddressHistory();
            addressHistory.forEach(it-> System.out.println("it.getCity() = " + it.getAddress().getCity()));

            System.out.println("============== START ============== ");
            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            favoriteFoods.forEach(System.out::println);

            System.out.println("============== START ============== ");
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getCity()));

            System.out.println("============== START ============== ");
            findMember.getFavoriteFoods().remove("pizza");
            findMember.getFavoriteFoods().add("pork");

            System.out.println("============== START ============== ");
//            findMember.getAddressHistory().remove(new AddressEntity("old1", "street1", "zipcode1"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street1", "zipcode1"));



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();

    }

}
