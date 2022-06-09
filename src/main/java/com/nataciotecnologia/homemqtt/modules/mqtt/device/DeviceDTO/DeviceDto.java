package com.nataciotecnologia.homemqtt.modules.mqtt.device.DeviceDTO;

import java.util.UUID;

public class DeviceDto {
    private UUID id;
    private String topic;
    private UUID interface_id;
    private String action;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public UUID getInterface_id() {
        return interface_id;
    }

    public void setInterface_id(UUID interface_id) {
        this.interface_id = interface_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
