package com.github.talmars.util;

import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.User;

/**
 * Created by vladislav on 30.04.2015.
 */

public final class FormMapper {

    public static User userRegistrationDTOToUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setLogin(userRegistrationDTO.getLogin());
        user.setPassword(userRegistrationDTO.getPassword());

        return user;
    }
}
