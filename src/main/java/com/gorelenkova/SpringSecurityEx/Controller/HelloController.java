package com.gorelenkova.SpringSecurityEx.Controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class HelloController {
    @GetMapping("/")
    public String SayHello(HttpServletRequest request){
       return "Hi Julia " + request.getSession().getId();
    }
}
