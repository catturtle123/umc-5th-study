package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.User_mission;

public interface UserMissionRepository extends JpaRepository<User_mission,Long> {
}
