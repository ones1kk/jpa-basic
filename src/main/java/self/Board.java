package self;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import jpabook.jpashop.domain.Member;

@Entity
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "board_no")
    private Long id;

    private String title;

    private String content;

    @OneToOne(mappedBy = "board")
    private User user;

//    @OneToMany(mappedBy = "comment")
////    @JoinColumn(name = "board_no")
//    private List<Comment> comments = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
