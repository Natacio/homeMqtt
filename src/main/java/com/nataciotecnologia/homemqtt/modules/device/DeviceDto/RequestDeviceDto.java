package com.nataciotecnologia.homemqtt.modules.device.DeviceDto;

import java.util.UUID;

public class RequestDeviceDto {

    private String sn;
    private String topic;
    private UUID user_id;

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

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }
}
