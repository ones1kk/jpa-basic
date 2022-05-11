package jpabook.jpashop;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import self.Board;
//import self.Comment;
import self.User;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // sign up
            User user = new User();
            user.setUserId("user1");
            user.setUserName("test");

            em.persist(user);

            System.out.println("user = " + user);

            // write board
            Board board = new Board();
//            board.setUser(user);
            board.setTitle("title1");
            board.setContent("content1");

            System.out.println("========board = " + board);

            em.persist(board);

            // write comment

//            Comment comment = new Comment();
////            comment.setUser(user);
//            comment.setComment("comment1");
//            comment.setBoard(board);
//            comment.setDateTime(LocalDateTime.now());
//
//            System.out.println("comment = " + comment);
//
//            em.persist(comment);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();
    }

}
