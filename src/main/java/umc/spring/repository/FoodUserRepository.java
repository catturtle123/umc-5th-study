package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.Food_user;

public interface FoodUserRepository extends JpaRepository<Food_user, Long> {
}
