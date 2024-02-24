package com.company.api.rest.model.mappers;

import com.company.api.rest.model.dto.ResponseDto;
import com.company.api.rest.model.dto.UserResponseDto;
import com.company.api.rest.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "user", target = "user")
    ResponseDto mapToDTO(UserEntity user, List<Long> roles);

    UserResponseDto mapToDTO(UserEntity user);
}
