package com.nataciotecnologia.homemqtt.modules.user.services;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.UserDto.PostUserDto;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateUser {

    @Autowired
    private UserRepository userRepository;

    public GetUserDto execute(PostUserDto request , UUID id){

        User userUpdate = new User();
        userUpdate.setId(id);
        userUpdate.setName(request.getName());
        userUpdate.setUsername(request.getUsername());
        userUpdate.setEmail(request.getEmail());
        System.out.println(userUpdate);
        if (request.getPassword() != null) userUpdate.setPassword(request.getPassword());

        return new GetUserDto(this.userRepository.save(userUpdate)) ;
    }
}
