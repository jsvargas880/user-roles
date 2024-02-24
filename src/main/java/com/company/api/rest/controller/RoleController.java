package com.company.api.rest.controller;

import com.company.api.rest.model.entities.RoleEntity;
import com.company.api.rest.service.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Roles controller", description = "This controller contains all endpoint to management the roles")
@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final IRoleService iRoleService;

    @Operation(summary = "This endpoint get all roles")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "All roles got successfully", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleEntity.class)))})})
    @GetMapping
    public ResponseEntity<List<RoleEntity>> getAllRole() {
        List<RoleEntity> roles = iRoleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<RoleEntity>> getByRoleName(@RequestParam String roleName) {
        List<RoleEntity> roles = iRoleService.getByRoleName(roleName);
        return ResponseEntity.ok(roles);
    }


}
