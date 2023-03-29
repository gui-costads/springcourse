package com.springcourse.course.services;

import com.springcourse.course.entities.Order;
import com.springcourse.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id){
        return orderRepository.findById(id).get();
    }
}
