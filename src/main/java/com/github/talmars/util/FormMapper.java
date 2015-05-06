package com.github.talmars.util;

import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.User;


public final class FormMapper {

    public static User userRegistrationDTOToUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setLogin(userRegistrationDTO.getLogin());
        user.setPassword(userRegistrationDTO.getPassword());

        return user;
    }
}
