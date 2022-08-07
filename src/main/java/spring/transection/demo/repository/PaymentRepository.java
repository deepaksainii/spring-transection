package spring.transection.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.transection.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
