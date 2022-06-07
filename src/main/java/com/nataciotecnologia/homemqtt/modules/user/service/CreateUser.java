package com.nataciotecnologia.homemqtt.modules.user.service;

import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public User execute(User user){
        User exists = userRepository.findByUsername(user.getUsername());
        if (exists != null){
            throw new Error("User exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}
