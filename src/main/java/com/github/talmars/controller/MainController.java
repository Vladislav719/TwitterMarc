package com.github.talmars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vladislav on 06.05.2015.
 */
@Controller
@RequestMapping
public class MainController {


    @RequestMapping(value = {"/index", ""})
    public String doP(Model model){
        return "redirect:/app/tweets/all";
    }

}
