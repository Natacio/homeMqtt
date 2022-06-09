package com.nataciotecnologia.homemqtt.modules.device.services;

import com.nataciotecnologia.homemqtt.modules.device.DeviceDto.DeviceRequestInterfaceDto;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceInterfaces;
import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.device.repositories.DeviceInterfaceRepository;
import com.nataciotecnologia.homemqtt.modules.device.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateDeviceInterface {

    private final DeviceInterfaceRepository deviceInterfaceRepository;
    private final DeviceRepository deviceRepository;

    public CreateDeviceInterface(DeviceInterfaceRepository deviceInterfaceRepository, DeviceRepository deviceRepository) {
        this.deviceInterfaceRepository = deviceInterfaceRepository;
        this.deviceRepository = deviceRepository;
    }

    public DeviceInterfaces execute(DeviceRequestInterfaceDto deviceDTO){
        DeviceInterfaces deviceInterfaces = new DeviceInterfaces();

        System.out.println(deviceDTO.getDevice());

        DeviceModel deviceModel = this.deviceRepository.findById(deviceDTO.getDevice()).orElse(null);

        if(deviceModel ==null) throw new Error("Device not found");

        deviceInterfaces.setSn(deviceDTO.getSn());
        deviceInterfaces.setTopic(deviceDTO.getTopic());
        deviceInterfaces.setDevice(deviceModel);

        return this.deviceInterfaceRepository.save(deviceInterfaces);
    }
}
