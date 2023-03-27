package com.springcourse.course.config;

import com.springcourse.course.entities.Order;
import com.springcourse.course.entities.User;
import com.springcourse.course.repositories.OrderRepository;
import com.springcourse.course.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "maria", "maria@gmail", "987612736273", "12356");
        User user2 = new User(null, "joao", "joao@gmail", "12783612837", "12635");

        Order  order1 = new Order(null, Instant.parse("2023-03-26T20:03:30Z"), user1);
        Order  order2 = new Order(null, Instant.parse("2023-03-26T19:03:30Z"), user2);
        Order  order3 = new Order(null, Instant.parse("2023-03-26T20:05:30Z"), user1);

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(order1,order2,order3));
    }
}
