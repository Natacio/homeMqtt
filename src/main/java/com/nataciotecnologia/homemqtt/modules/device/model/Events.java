package com.nataciotecnologia.homemqtt.modules.device.model;

import com.nataciotecnologia.homemqtt.modules.user.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "interface_device")
    private DeviceInterfaces interfaceDevice;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DeviceInterfaces getInterfaceDevice() {
        return interfaceDevice;
    }

    public void setInterfaceDevice(DeviceInterfaces interfaceDevice) {
        this.interfaceDevice = interfaceDevice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
