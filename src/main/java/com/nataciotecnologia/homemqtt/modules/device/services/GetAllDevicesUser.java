package com.nataciotecnologia.homemqtt.modules.device.services;

import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.DeviceResponseDto;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.device.repositories.DeviceRepository;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import com.nataciotecnologia.homemqtt.modules.user.repository.UserRepository;
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

    public List<DeviceResponseDto> getAll(UUID id){
        User user = this.userRepository.findById(id).get();

        List<DeviceModel> devices = this.deviceRepository.findByUserId(id);

        List<DeviceResponseDto> deviceResponseDtoList = devices.stream().map(DeviceResponseDto::new).collect(Collectors.toList());

        return  deviceResponseDtoList;
    }
}
