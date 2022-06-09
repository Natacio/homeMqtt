package com.nataciotecnologia.homemqtt.modules.device.repositories;

import com.nataciotecnologia.homemqtt.modules.device.model.DeviceInterfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceInterfaceRepository extends JpaRepository<DeviceInterfaces, UUID> {
}
