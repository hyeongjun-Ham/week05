package sparta.week05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.week05.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
