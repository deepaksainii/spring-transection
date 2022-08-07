package spring.transection.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.transection.demo.dto.OrderRequest;
import spring.transection.demo.dto.OrderResponse;
import spring.transection.demo.entity.Order;
import spring.transection.demo.entity.Payment;
import spring.transection.demo.exception.PaymentException;
import spring.transection.demo.repository.OrderRepository;
import spring.transection.demo.repository.PaymentRepository;
import spring.transection.demo.service.OrderService;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
