package com.nataciotecnologia.homemqtt.modules.device.model.repositories;

import com.nataciotecnologia.homemqtt.modules.device.model.DeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceModel,UUID> {
}
