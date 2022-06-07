package com.nataciotecnologia.homemqtt.modules.user.UserDto;

import com.nataciotecnologia.homemqtt.modules.user.model.User;

import javax.persistence.Column;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GetUserDto {
    private UUID id;
    private String name;
    private String username;
    private String email;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public GetUserDto(User user) {
        this.name = user.getEmail();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.id = user.getId();
    }



}
