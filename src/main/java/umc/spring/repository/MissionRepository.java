package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Market;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.User_mission;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    public Page<Mission> findAllByMarket(Market market, PageRequest pageRequest);



}
