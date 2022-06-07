package com.nataciotecnologia.homemqtt.modules.user.UserDto;

import com.nataciotecnologia.homemqtt.modules.user.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PostUserDto {

    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public User convert(){
        User user = new User();

        user.setPassword(this.getPassword());
        user.setEmail(this.getEmail());
        user.setUsername(this.username);
        user.setName(this.name);

        return user;
    }
}
