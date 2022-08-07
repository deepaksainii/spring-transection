package spring.transection.demo.dto;

import lombok.Getter;
import lombok.Setter;
import spring.transection.demo.entity.Order;
import spring.transection.demo.entity.Payment;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
