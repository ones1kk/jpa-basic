package jpabook.jpashop;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import self.Board;
import self.Comment;
import self.User;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // sign up
            User user1 = new User();
            user1.setUserId("user1");
            user1.setUserName("test1");

            User user2 = new User();
            user2.setUserId("user2");
            user2.setUserName("test2");

            em.persist(user1);
            em.persist(user2);

            // write board
            Board board = new Board();
            board.addUser(user1);
            board.setTitle("title1");
            board.setContent("content1");

            Board board1 = new Board();
            board1.addUser(user1);
            board1.setTitle("title2");
            board1.setContent("content2");

            em.persist(board);
            em.persist(board1);



            Board findBoard = em.find(Board.class, board1.getId());
            User findUserByBoardNo = findBoard.getUser();
            System.out.println(
                "findUserByBoardNo.getUserName() = " + findUserByBoardNo.getUserName());

            User findUser = em.find(User.class, user1.getId());
            System.out.println("============================================================");
            findUser.getBoards().forEach(brd -> {
                System.out.println(brd.getTitle());
                System.out.println(brd.getContent());
            });

            // write comment
            Comment comment1 = new Comment();
            comment1.setDateTime(LocalDateTime.now());
            comment1.setBoard(board1);
            comment1.setComment("comment1");
            comment1.setUser(user1);


            em.persist(comment1);
            System.out.println("============================================================");
            user1.getComments().forEach(cmt -> {
                System.out.println(cmt.getComment());
            });

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.clear();
        }

        emf.close();
    }

}
