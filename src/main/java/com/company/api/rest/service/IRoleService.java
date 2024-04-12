package com.company.api.rest.service;

import com.company.api.rest.model.entities.RoleEntity;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    List<RoleEntity> getAllRoles();
    List<RoleEntity> getByRoleName(String roleName);
    Map<String, Object> getAllRolesPageable(int page, int size);

}
