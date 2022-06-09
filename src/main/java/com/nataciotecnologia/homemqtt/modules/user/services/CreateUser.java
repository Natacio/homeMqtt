package com.nataciotecnologia.homemqtt.modules.user.services;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.UserDto.PostUserDto;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateUser {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    public GetUserDto execute(PostUserDto user){

        Optional<User> exists = userRepository.findByUsername(user.getUsername());
        if (!exists.isEmpty()){
            throw new Error("User exists");
        }
        user.setPassword(encoder.encode(user.getPassword()));

        return new GetUserDto(userRepository.save(user.convert()));
    }
}
