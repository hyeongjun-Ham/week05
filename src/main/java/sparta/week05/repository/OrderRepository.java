package sparta.week05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sparta.week05.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
