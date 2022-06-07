package com.nataciotecnologia.homemqtt.modules.user.services;

import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUser {
    @Autowired
    private UserRepository userRepository;

    public void execute(UUID id){
        User user = this.userRepository.findById(id).orElse(null);
        if(user == null){
            throw new Error("user not found");
        }
        this.userRepository.deleteById(id);
    }
}
