package com.nile.orderservice;

import com.nile.orderservice.models.Order;
import com.nile.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orders")
    public Iterable<Order> getAllOrders(@RequestHeader("Authorization") String token) {
        return orderService.getAllOrders(token);
    }

    @RequestMapping("/orders/buyer")
    public Iterable<Order> getOrdersByBuyerId(@RequestHeader("Authorization") String token) {
        return orderService.getOrdersByBuyerID(token);
    }

    @RequestMapping("/orders/{id}")
    public Optional<Order> getOrder(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        return orderService.getOrder(token, UUID.fromString(id));
    }

    @PostMapping("/orders")
    public void addOrder(@RequestHeader("Authorization") String token, @RequestBody Order order) {
        orderService.addOrder(token, order);
    }

    @PutMapping("/orders")
    public void updateOrder(@RequestHeader("Authorization") String token, @RequestBody Order order) {
        orderService.updateOrder(token, order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@RequestHeader("Authorization") String token, @PathVariable("id") String id) {
        orderService.deleteOrder(token, UUID.fromString(id));
    }
}
