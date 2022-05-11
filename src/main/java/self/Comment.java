//package self;
//
//import java.time.LocalDateTime;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import jpabook.jpashop.domain.Member;
//
////@Entity
//public class Comment {
//    @Id
//    @GeneratedValue
//    @Column(name = "comment_no")
//    private Long id;
//    private String comment;
//    private LocalDateTime dateTime;
//
////    @ManyToOne
////    @JoinColumn(name = "user_no")
////    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "board_no")
//    private Board board;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public LocalDateTime getDateTime() {
//        return dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
//
////    public User getUser() {
////        return user;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    public void setBoard(Board board) {
//        this.board = board;
//    }
//}
