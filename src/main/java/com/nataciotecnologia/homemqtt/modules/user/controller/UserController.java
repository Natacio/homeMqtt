package com.nataciotecnologia.homemqtt.modules.user.controller;

import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.service.CreateUser;
import com.nataciotecnologia.homemqtt.modules.user.service.GetAllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GetAllUsers getAllUsers;

    @Autowired
    private CreateUser createUser;

    @GetMapping
    public List<User> index (){
        return this.getAllUsers.execute();
    }

    @PostMapping
    public ResponseEntity<User> created (@RequestBody User user){
        System.out.println(user);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.createUser.execute(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
