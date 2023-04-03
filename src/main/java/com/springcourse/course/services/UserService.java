package com.springcourse.course.services;

import com.springcourse.course.entities.User;
import com.springcourse.course.repositories.UserRepository;
import com.springcourse.course.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user){
        User userToUpdate = userRepository.getReferenceById(id);
        updateDate(userToUpdate, user);
        return userRepository.save(userToUpdate);
    }

    private void updateDate(User userToUpdate, User user) {
        userToUpdate.setName(user.getName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhone(user.getPhone());
    }
}
