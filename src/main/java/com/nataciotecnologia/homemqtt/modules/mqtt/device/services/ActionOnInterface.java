package com.nataciotecnologia.homemqtt.modules.mqtt.device.services;

import com.nataciotecnologia.homemqtt.modules.mqtt.MqttPublish;
import com.nataciotecnologia.homemqtt.modules.mqtt.device.Device;
import com.nataciotecnologia.homemqtt.modules.mqtt.device.DeviceDTO.DeviceDto;
import org.springframework.stereotype.Service;

@Service
public class ActionOnInterface {
    public void execute(DeviceDto device){
        MqttPublish.publishMenssage(device);
    }
}
