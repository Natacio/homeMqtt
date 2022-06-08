package com.nataciotecnologia.homemqtt.modules.device.services;

import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.DeviceResponseDto;
import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.RequestDeviceDto;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.device.repositories.DeviceRepository;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDevice {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserRepository userRepository;

    public DeviceResponseDto execute(RequestDeviceDto device){
        User user = this.userRepository.findById(device.getUser_id()).orElse(null);
        if(user == null)throw new Error("User not found");

        DeviceModel deviceModel = new DeviceModel();
        deviceModel.setSn(device.getSn());
        deviceModel.setTopic(device.getTopic());
        deviceModel.setUser(user);

        return new DeviceResponseDto(this.deviceRepository.save(deviceModel));
    }
}
