package com.nataciotecnologia.homemqtt.modules.device.DeviceDto;

import com.nataciotecnologia.homemqtt.modules.device.model.DeviceInterfaces;

import java.util.UUID;

public class DeviceRequestInterfaceDto {
    private String sn;
    private String topic;
    private UUID device;

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

    public UUID getDevice() {
        return device;
    }

    public void setDevice(UUID device) {
        this.device = device;
    }

}
