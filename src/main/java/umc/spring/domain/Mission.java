package umc.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.error.Mark;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.User_mission;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 50)
    private String content;

    @Column(nullable = false)
    private int distinctNumber;

    @Column(nullable = false)
    private int point;

    @Column(nullable = false)
    private boolean isSuccess;

    @ManyToOne
    @JoinColumn(name = "marketId")
    private Market market;

    @OneToMany(mappedBy = "mission")
    private List<User_mission> userMissionList = new ArrayList<>();
}
