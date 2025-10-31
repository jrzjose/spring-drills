package org.springmix.webapp.data.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmix.webapp.data.entity.StaffMember;

public interface StaffRepository extends JpaRepository<StaffMember, UUID> {
    
}
