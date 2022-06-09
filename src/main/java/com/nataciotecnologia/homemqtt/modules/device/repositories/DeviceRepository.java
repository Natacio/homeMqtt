package com.nataciotecnologia.homemqtt.modules.device.repositories;

import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import com.nataciotecnologia.homemqtt.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceModel,UUID> {

    public List<DeviceModel> findByUserId(UUID id);
}
