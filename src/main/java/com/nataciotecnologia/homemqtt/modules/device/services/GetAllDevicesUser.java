package com.nataciotecnologia.homemqtt.modules.device.services;

import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.DeviceResponseDto;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.device.repositories.DeviceRepository;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
import com.nataciotecnologia.homemqtt.modules.user.services.GetUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GetAllDevicesUser {
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    GetUserLogin getUserLogin;

    public List<DeviceResponseDto> getAll(){

        List<DeviceModel> devices = this.deviceRepository.findByUserId(getUserLogin.execute().getId());

        List<DeviceResponseDto> deviceResponseDtoList = devices.stream().map(DeviceResponseDto::new).collect(Collectors.toList());

        return  deviceResponseDtoList;
    }
}
