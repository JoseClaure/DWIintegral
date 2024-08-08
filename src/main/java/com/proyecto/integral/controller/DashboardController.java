package com.proyecto.integral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/principal")
    public String inicio(){
        return "principal";
    }

    
}