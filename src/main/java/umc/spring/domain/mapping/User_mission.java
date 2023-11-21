package umc.spring.domain.mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User_mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "missionId")
    private Mission mission;

    public void setUser(User user) {
        if(this.user != null)
            user.getUserMissionList().remove(this);
        this.user = user;
        user.getUserMissionList().add(this);
    }

    public void setMission(Mission mission) {
        if(this.mission != null)
            mission.getUserMissionList().remove(this);
        this.mission = mission;
        mission.getUserMissionList().add(this);
    }
}
