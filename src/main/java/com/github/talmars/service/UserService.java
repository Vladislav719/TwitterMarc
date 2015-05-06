package com.github.talmars.service;

import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.User;

/**
 * Created by vladislav on 30.04.2015.
 */
public interface UserService {

    User createUser(UserRegistrationDTO userRegistrationDTO);
    User getUserByLogin(String login);
}
