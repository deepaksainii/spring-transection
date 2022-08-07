package spring.transection.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.transection.demo.dto.OrderRequest;
import spring.transection.demo.dto.OrderResponse;
import spring.transection.demo.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
