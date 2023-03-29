package com.springcourse.course.services;

import com.springcourse.course.entities.User;
import com.springcourse.course.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
}
