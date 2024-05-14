package com.example.minh.repository;

import com.example.minh.entity.Role;
import com.example.minh.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(ERole roleName);

}
