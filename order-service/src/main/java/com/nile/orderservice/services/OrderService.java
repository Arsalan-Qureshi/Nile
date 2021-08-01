package com.nile.orderservice.services;

import com.nile.orderservice.models.Order;
import com.nile.orderservice.models.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(String token) {
        if (authenticateAdmin(token).matches("OK")) {
            List<Order> orders = orderRepository.findAll();
            return orders;
        } else {
            return null;
        }
    }

    public Iterable<Order> getOrdersByBuyerID(String token) {
        if (authenticateBuyer(token).matches("OK")) {
            String buyerId = getBuyerId(token);
            return orderRepository.findByBuyerId(buyerId);
        } else {
            return null;
        }
    }

    public Optional<Order> getOrder(String token, UUID id) {
        if (authenticateBuyer(token).matches("OK")) {
            // Buyer ID is matched after extracting username from JWT.
            Optional<Order> order = orderRepository.findById(id);
            if (getBuyerId(token).matches(order.get().getBuyerId())) {
                return order;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // Order is created after the user checkouts.
    public void addOrder(String token, Order order) {
        if (authenticateBuyer(token).matches("OK")) {
            orderRepository.save(order);
        }
    }

    public void updateOrder(String token, Order order) {
        if (authenticateAdmin(token).matches("OK")) {
            orderRepository.save(order);
        }
    }

    public void deleteOrder(String token, UUID id) {
        if (authenticateAdmin(token).matches("OK")) {
            orderRepository.deleteById(id);
        }
    }

    public String authenticateBuyer(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://buyer-authentication-service/buyer/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    public String authenticateAdmin(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://admin-authentication-service/admin/authenticate", HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }

    public String getBuyerId(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://buyer-authentication-service/buyer/userName", HttpMethod.GET, entity, String.class);
        String userName = responseEntity.getBody();
        if (userName != null) {
            ResponseEntity<Object[]> responseEntityObject = restTemplate.exchange("http://buyer-service/buyers/search/" + userName, HttpMethod.GET, entity, Object[].class);
            Object[] objects = responseEntityObject.getBody();
            return objects[0].toString();
        } else {
            return null;
        }
    }
}