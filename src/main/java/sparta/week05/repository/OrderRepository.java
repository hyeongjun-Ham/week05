package sparta.week05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.week05.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
