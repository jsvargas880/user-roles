package com.company.api.rest.controller.impl;

import com.company.api.rest.controller.IRoleController;
import com.company.api.rest.model.entities.RoleEntity;
import com.company.api.rest.service.IRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController implements IRoleController {

    private final IRoleService iRoleService;

    @Override
    @GetMapping
    public ResponseEntity<List<RoleEntity>> getAllRole() {
        log.info("Request Received in getAllRole() method ");
        List<RoleEntity> roles = iRoleService.getAllRoles();
        log.info("returning {} roles", roles.size());
        return ResponseEntity.ok(roles);
    }

    @Override
    @GetMapping("/byName")
    public ResponseEntity<List<RoleEntity>> getByRoleName(@RequestParam String roleName) {
        List<RoleEntity> roles = iRoleService.getByRoleName(roleName);
        return ResponseEntity.ok(roles);
    }

    @Override
    @GetMapping("/pageable")
    public ResponseEntity<Map<String, Object>> getAllRolePageable(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "1") int size) {
        log.info("Request Received in getAllRolePageable() method ");
        Map<String, Object> roles = iRoleService.getAllRolesPageable(page, size);
        log.info("returning {} roles", roles.size());
        return ResponseEntity.ok(roles);
    }

}
