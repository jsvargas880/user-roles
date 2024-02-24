package com.company.api.rest.service.impl;

import com.company.api.rest.model.dto.ResponseDto;
import com.company.api.rest.model.entities.UserEntity;
import com.company.api.rest.model.mappers.UserMapper;
import com.company.api.rest.repository.IUserRepository;
import com.company.api.rest.repository.IUserRoleRepository;
import com.company.api.rest.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    private final IUserRoleRepository iUserRoleRepository;
    private final UserMapper userMapper;


    @Override
    public ResponseDto retrieveUserByEmail(String email) {
        UserEntity user = getUSer(email);
        List<Long> roles = getRoles(user);

        return userMapper.mapToDTO(user, roles);
    }

    private UserEntity getUSer(String email){
        return iUserRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
    }

    private List<Long> getRoles(UserEntity user){
        return iUserRoleRepository.findByUser(user).stream().map(userRole -> userRole.getRole().getId())
                .collect(Collectors.toList());
    }
}
