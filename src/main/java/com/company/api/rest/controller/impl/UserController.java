package com.company.api.rest.controller.impl;

import com.company.api.rest.model.dto.ResponseDto;
import com.company.api.rest.model.dto.UserRolesRequest;
import com.company.api.rest.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User controller", description = "This controller contains all endpoint to management the users")
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Operation(summary = "This endpoint get a user by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User got by email successfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseDto.class)) }) })

    @PostMapping(value = "/roles", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> retrieveUserByEmail(@RequestBody UserRolesRequest userRolesRequest) {
        var response = iUserService.retrieveUserByEmail(userRolesRequest.getEmail());
        return ResponseEntity.ok(response);
    }
}
