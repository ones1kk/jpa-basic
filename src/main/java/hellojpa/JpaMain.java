package hellojpa;

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
            Address address = new Address("city", "street", "zipcode");

            Member member1 = new Member();
            member1.setUsername("hello1");
            member1.setHomeAddress(address);

            Member member2 = new Member();
            member2.setUsername("hello2");
            member2.setHomeAddress(address);

            em.persist(member1);
            em.persist(member2);

            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
            member1.setHomeAddress(newAddress);

//            member1.getHomeAddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();

    }

}
