package com.company.api.rest.service.impl;

import com.company.api.rest.model.entities.RoleEntity;
import com.company.api.rest.repository.IRoleRepository;
import com.company.api.rest.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository iRoleRepository;

    @Override
    public List<RoleEntity> getAllRoles() {
        return iRoleRepository.findAll();
    }

    @Override
    public List<RoleEntity> getByRoleName(String roleName) {
        return iRoleRepository.getByRoleName(roleName);
    }

}
