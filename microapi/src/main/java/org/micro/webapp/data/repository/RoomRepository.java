package org.micro.webapp.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.micro.webapp.data.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, UUID>{
   
} 