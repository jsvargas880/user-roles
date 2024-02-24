package com.company.api.rest.repository;

import com.company.api.rest.model.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

    List<RoleEntity> getByRoleName(String roleName);
}
