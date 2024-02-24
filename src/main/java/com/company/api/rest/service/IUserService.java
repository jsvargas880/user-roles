package com.company.api.rest.service;

import com.company.api.rest.model.dto.ResponseDto;

public interface IUserService {
    ResponseDto retrieveUserByEmail(String email);
}
