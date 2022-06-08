package com.nataciotecnologia.homemqtt.modules.device.DeviceDto;

import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.user.UserDto.GetUserDto;
import java.util.UUID;

public class DeviceResponseDto {
    private UUID id;

    private String sn;

    private String topic;

   // private GetUserDto user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public DeviceResponseDto(DeviceModel device) {
        this.id = device.getId();
        this.sn = device.getSn();
        this.topic = device.getTopic();
        //this.user = new GetUserDto(device.getUser());
    }
}
