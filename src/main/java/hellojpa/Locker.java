package hellojpa;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import hellojpa.Member;

//@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long id;

    private String name;

//    @OneToOne(mappedBy = "locker")
//    private Member member;
}
