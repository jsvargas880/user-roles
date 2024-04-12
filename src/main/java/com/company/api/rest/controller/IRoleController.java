package com.company.api.rest.controller;

import com.company.api.rest.model.entities.RoleEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Tag(name = "Roles controller", description = "This controller contains all endpoint to management the roles")
public interface IRoleController {

    @Operation(summary = "This endpoint get all roles")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "All roles got successfully", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleEntity.class)))})})
    ResponseEntity<List<RoleEntity>> getAllRole();

    @Operation(summary = "This endpoint get role by name")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "role by name got successfully", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleEntity.class)))})})
    ResponseEntity<List<RoleEntity>> getByRoleName(String roleName);

    @Operation(summary = "This endpoint get all roles by pages")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "All roles got successfully", content = {
            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = RoleEntity.class)))})})
    ResponseEntity<Map<String, Object>> getAllRolePageable(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "1") int size);
}
