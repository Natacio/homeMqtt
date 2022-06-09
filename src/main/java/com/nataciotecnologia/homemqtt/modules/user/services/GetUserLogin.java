package com.nataciotecnologia.homemqtt.modules.user.services;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GetUserLogin {
    @Autowired
    UserRepository userRepository;

    public GetUserDto execute() {
        Authentication aut = SecurityContextHolder.getContext().getAuthentication();
        if (aut.isAuthenticated()){
            User user = userRepository.findByUsername(aut.getName()).orElse(null);
            return new GetUserDto(user);
        }
        return new GetUserDto(null);
    }

}
