package com.company.api.rest.controller.impl;

import com.company.api.rest.controller.IRoleController;
import com.company.api.rest.model.entities.RoleEntity;
import com.company.api.rest.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController implements IRoleController {

    private final IRoleService iRoleService;

    @Override
    @GetMapping
    public ResponseEntity<List<RoleEntity>> getAllRole() {
        List<RoleEntity> roles = iRoleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @Override
    @GetMapping("/byName")
    public ResponseEntity<List<RoleEntity>> getByRoleName(@RequestParam String roleName) {
        List<RoleEntity> roles = iRoleService.getByRoleName(roleName);
        return ResponseEntity.ok(roles);
    }


}
