package spring.transection.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.transection.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
