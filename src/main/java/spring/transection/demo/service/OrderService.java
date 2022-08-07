package spring.transection.demo.service;

import spring.transection.demo.dto.OrderRequest;
import spring.transection.demo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
