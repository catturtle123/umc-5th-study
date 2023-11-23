package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.Food_user;
import umc.spring.domain.mapping.User_mission;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 10)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false, length = 30)
    private String address;


    private String password;

    @Column(nullable = false)
    private int point;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime inActiveTime;

    @OneToMany(mappedBy = "user")
    private List<Food_user> foodUserList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Request> requestList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<User_mission> userMissionList = new ArrayList<>();
}
