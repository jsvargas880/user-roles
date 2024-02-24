package com.company.api.rest.service;

import com.company.api.rest.model.entities.RoleEntity;

import java.util.List;

public interface IRoleService {
    List<RoleEntity> getAllRoles();
    List<RoleEntity> getByRoleName(String roleName);

}
