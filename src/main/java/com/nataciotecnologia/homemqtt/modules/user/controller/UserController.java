package com.nataciotecnologia.homemqtt.modules.user.controller;

import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import com.nataciotecnologia.homemqtt.modules.user.UserDto.PostUserDto;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.service.CreateUser;
import com.nataciotecnologia.homemqtt.modules.user.service.GetAllUsers;
import com.nataciotecnologia.homemqtt.modules.user.service.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private CreateUser createUser;

    @Autowired
    private UpdateUser updateUser;

    @GetMapping
    public List<GetUserDto> index (){

        return this.getAllUsers.execute();
    }

    @PostMapping
    public ResponseEntity<GetUserDto> created (@RequestBody @Valid PostUserDto user){

        try {
            GetUserDto userDto = new GetUserDto(this.createUser.execute(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
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
}
