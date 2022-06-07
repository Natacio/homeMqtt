package com.nataciotecnologia.homemqtt.modules.user.service;

import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUsers {
    @Autowired
    UserRepository userRepository;

    public List<User> execute(){
        return userRepository.findAll();
    }
}
