package com.springcourse.course.config;

import com.springcourse.course.entities.Category;
import com.springcourse.course.entities.Order;
import com.springcourse.course.entities.User;
import com.springcourse.course.entities.enums.OrderStatus;
import com.springcourse.course.repositories.CategoryRepository;
import com.springcourse.course.repositories.OrderRepository;
import com.springcourse.course.repositories.UserRepository;
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
    private final CategoryRepository categoryRepository;
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "maria", "maria@gmail", "987612736273", "12356");
        User user2 = new User(null, "joao", "joao@gmail", "12783612837", "12635");

        Order  order1 = new Order(null, Instant.parse("2023-03-26T20:03:30Z"), user1, OrderStatus.PAID);
        Order  order2 = new Order(null, Instant.parse("2023-03-26T19:03:30Z"), user2, OrderStatus.CANCELED);
        Order  order3 = new Order(null, Instant.parse("2023-03-26T20:05:30Z"), user1, OrderStatus.DELIVERED);

        Category category1 = new Category(null, "Books");
        Category category2 = new Category(null, "Computers");


        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(order1,order2,order3));
        categoryRepository.saveAll(Arrays.asList(category1,category2));
    }
}
