package com.nataciotecnologia.homemqtt.modules.user.controller;

import com.nataciotecnologia.homemqtt.modules.mqtt.device.Device;
import com.nataciotecnologia.homemqtt.modules.mqtt.device.DeviceDTO.DeviceDto;
import com.nataciotecnologia.homemqtt.modules.mqtt.device.services.ActionOnInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceAction {
    @Autowired
    private ActionOnInterface actionOnInterface;

    @PostMapping
    public ResponseEntity index(@RequestBody DeviceDto device){
        this.actionOnInterface.execute(device);
        return ResponseEntity.ok().body("interface acionada");
    }
}
