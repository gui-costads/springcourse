package com.springcourse.course.config;

import com.springcourse.course.entities.User;
import com.springcourse.course.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "maria", "maria@gmail", "987612736273", "12356");
        User user2 = new User(null, "joao", "joao@gmail", "12783612837", "12635");

        userRepository.saveAll(Arrays.asList(user1,user2));
    }
}
