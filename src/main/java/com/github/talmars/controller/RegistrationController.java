package com.github.talmars.controller;

import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.User;
import com.github.talmars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladislav on 30.04.2015.
 */
@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationPage(ModelMap map) {
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(Model model, UserRegistrationDTO userRegistrationDTO) {

        User user = userService.createUser(userRegistrationDTO);
        model.addAttribute("newUser", user);

        return "login";
    }


}
