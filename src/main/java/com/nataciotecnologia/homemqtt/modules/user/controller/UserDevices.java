package com.nataciotecnologia.homemqtt.modules.user.controller;

import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.DeviceResponseDto;
import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.RequestDeviceDto;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.device.services.CreateDevice;
import com.nataciotecnologia.homemqtt.modules.device.services.GetAllDevicesUser;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user/devices")
public class UserDevices {

    @Autowired
    private GetAllDevicesUser getAllDevicesUser;

    @Autowired
    private CreateDevice createDevice;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<DeviceResponseDto> index(){
        User user = this.userRepository.findByUsername("keka");
        return getAllDevicesUser.getAll(user.getId());
    }

    @PostMapping
    public ResponseEntity<DeviceResponseDto> create(@RequestBody RequestDeviceDto device){
        try {
            return ResponseEntity.ok().body(this.createDevice.execute(device));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
