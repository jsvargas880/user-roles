package com.company.api.rest.repository;

import com.company.api.rest.model.entities.UserEntity;
import com.company.api.rest.model.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    List<UserRoleEntity> findByUser(UserEntity user);
}
