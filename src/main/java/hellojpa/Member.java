//package hellojpa;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
////@TableGenerator(
////    name = "MEMBER_SEQ_GENERATOR",
////    table = "MY_SEQUENCES",
////    pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
//public class Member {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.TABLE,
////        generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue
//    @Column(name = "MEMBER_ID")
//    private Long id;
//
//    @Column(name = "USERNAME", nullable = false)
//    private String username;
//
////    @Column(name = "TEAM_ID")
////    private Long teamId;
//
//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;
//
//    @OneToOne
//    @JoinColumn(name="LOCKER_ID")
//    private Locker locker;

//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
//}
