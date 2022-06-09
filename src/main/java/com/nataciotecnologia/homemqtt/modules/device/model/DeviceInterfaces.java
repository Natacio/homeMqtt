package com.nataciotecnologia.homemqtt.modules.device.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "interfaces")
public class DeviceInterfaces {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    private String sn;

    private String topic;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private DeviceModel device;

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

    public DeviceModel getDevice() {
        return device;
    }

    public void setDevice(DeviceModel device) {
        this.device = device;
    }
}
