package sparta.week05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.week05.model.Food;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long id);
}
