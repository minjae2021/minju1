package project.minju1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.minju1.entity.Item;
import project.minju1.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByMemberId(Long id);
}
