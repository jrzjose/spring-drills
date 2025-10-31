package org.micro.webapp.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.micro.webapp.data.entity.StaffMember;

public interface StaffRepository extends JpaRepository<StaffMember, UUID> {
    
}
