package com.nataciotecnologia.homemqtt.modules.user.repository;

import com.nataciotecnologia.homemqtt.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
