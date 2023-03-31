package com.springcourse.course.config;

import com.springcourse.course.entities.*;
import com.springcourse.course.entities.enums.OrderStatus;
import com.springcourse.course.repositories.*;
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
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Books");
        Category category2 = new Category(null, "Computers");
        Category category3 = new Category(null, "Eletronics");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(category1,category2, category3));
        productRepository.saveAll(Arrays.asList(product1,product2,product3, product4, product5));

        product1.getCategories().add(category2);

        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category1);

        productRepository.saveAll(Arrays.asList(product1,product2,product3, product4, product5));

        User user1 = new User(null, "maria", "maria@gmail", "987612736273", "12356");
        User user2 = new User(null, "joao", "joao@gmail", "12783612837", "12635");


        Order  order1 = new Order(null, Instant.parse("2023-03-26T20:03:30Z"), user1, OrderStatus.PAID);
        Order  order2 = new Order(null, Instant.parse("2023-03-26T19:03:30Z"), user2, OrderStatus.CANCELED);
        Order  order3 = new Order(null, Instant.parse("2023-03-26T20:05:30Z"), user1, OrderStatus.WAITING_PAYMENT);

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(order1,order2,order3));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
        OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1,orderItem2,orderItem3, orderItem4));

        Payment pay1 = new Payment(null,Instant.parse("2023-03-26T22:03:30Z"), order1);
        order1.setPayment(pay1);

        orderRepository.save(order1);
    }
}
