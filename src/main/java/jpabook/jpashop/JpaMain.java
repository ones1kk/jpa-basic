package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import self.Board;
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

            // write board
            Board board = new Board();
            board.addUser(user);
            board.setTitle("title1");
            board.setContent("content1");

            Board board1 = new Board();
            board1.addUser(user);
            board1.setTitle("title2");
            board1.setContent("content2");



            em.persist(board);
            em.persist(board1);

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
