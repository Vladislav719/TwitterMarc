package com.github.talmars.util;

import com.github.talmars.model.User;
import com.github.talmars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by vladislav on 05.05.2015.
 */
public class SecurityContextUtil {

    UserService userService;

    public SecurityContextUtil(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        System.out.println("USERNAE" + username);
        User user = userService.getUserByLogin(username);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return isNoAuth(authentication) ? null : user;
    }

    public boolean isNoAuth(Authentication authentication) {
        return authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken);
    }

}
