package com.nataciotecnologia.homemqtt.modules.user.service;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllUsers {
    @Autowired
    private UserRepository userRepository;


    public List<GetUserDto> execute(){
        List<User> users = this.userRepository.findAll();
        return users.stream().map(GetUserDto::new).collect(Collectors.toList());
    }
}
