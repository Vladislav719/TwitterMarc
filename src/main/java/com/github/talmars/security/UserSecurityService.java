package com.github.talmars.security;

import com.github.talmars.model.User;

/**
 * Created by vladislav on 30.04.2015.
 */
public interface UserSecurityService {

    public User getUser(String login);
}
