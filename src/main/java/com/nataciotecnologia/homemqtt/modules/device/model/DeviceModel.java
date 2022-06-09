package com.nataciotecnologia.homemqtt.modules.device.model;

import com.nataciotecnologia.homemqtt.modules.user.model.User;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "devices")
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, unique = true, nullable = false,columnDefinition = "BINARY(16)")
    private UUID id;

    private String sn;

    private String topic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //ManyDevice One User

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
