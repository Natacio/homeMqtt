package com.nataciotecnologia.homemqtt.modules.user.controller;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.UserDto.PostUserDto;
import com.nataciotecnologia.homemqtt.modules.user.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GetAllUsers getAllUsers;

    @Autowired
    GetUserLogin getUserLogin;

    @Autowired
    private CreateUser createUser;

    @Autowired
    private UpdateUser updateUser;

    @Autowired
    private GetOneUser getOneUser;

    @Autowired
    DeleteUser deleteUser;

    @GetMapping
    public List<GetUserDto> index (){

        return this.getAllUsers.execute();
    }

    @PostMapping
    public ResponseEntity<GetUserDto> created (@RequestBody @Valid PostUserDto user){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.createUser.execute(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserDto> getOneUser(@PathVariable UUID id){
        try {
            return ResponseEntity.ok().body(this.getOneUser.execute(id));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<GetUserDto> update (@PathVariable UUID id ,
                                                   @RequestBody @Valid PostUserDto user){
        try {
            return ResponseEntity.ok().body(this.updateUser.execute(user,id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        this.deleteUser.execute(id);
    }

    @GetMapping("/teste")
    public ResponseEntity<GetUserDto> teste(){

        try {
            return ResponseEntity.ok().body(getUserLogin.execute());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
