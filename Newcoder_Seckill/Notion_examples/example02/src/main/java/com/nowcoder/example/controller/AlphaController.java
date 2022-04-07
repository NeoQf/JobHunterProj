package com.nowcoder.example.controller;

import com.nowcoder.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/alpha")
public class AlphaController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/foo", method = RequestMethod.GET)
    @ResponseBody
    public String getFoo() {
        return "Spring Boot.";
    }

}
