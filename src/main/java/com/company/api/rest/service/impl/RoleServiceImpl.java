package com.company.api.rest.service.impl;

import com.company.api.rest.model.entities.RoleEntity;
import com.company.api.rest.repository.IRoleRepository;
import com.company.api.rest.service.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository iRoleRepository;

    @Override
    public List<RoleEntity> getAllRoles() {
        log.info("Retrieving all roles");
        return iRoleRepository.findAll();
    }

    @Override
    public List<RoleEntity> getByRoleName(String roleName) {
        return iRoleRepository.getByRoleName(roleName);
    }

    @Override
    public Map<String, Object> getAllRolesPageable(int page, int size) {
        log.info("Retrieving all roles by pages");
        Page<RoleEntity> roles = iRoleRepository.findAll(PageRequest.of(page, size));
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("roles", roles.getContent());
        response.put("pageNumber", roles.getPageable().getPageNumber());
        response.put("pageSize", roles.getPageable().getPageSize());
        response.put("offset", roles.getPageable().getOffset());
        response.put("total pages", roles.getTotalPages());
        response.put("total elements", roles.getTotalElements());
        return response;
    }


}
