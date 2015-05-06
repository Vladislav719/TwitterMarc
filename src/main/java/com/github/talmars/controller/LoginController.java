package com.github.talmars.controller;

import com.github.talmars.model.User;
import com.github.talmars.service.UserService;
import com.github.talmars.util.SecurityContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by vladislav on 05.05.2015.
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            ModelMap map) {
        if (error != null)
            map.addAttribute("error", "Invalid username or password");
        User user = new SecurityContextUtil(userService).getCurrentUser();

        if (user != null)
            return "redirect:/";
        else
            return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String renderLoginPage(ModelMap map) {
        return "login";
    }
}
