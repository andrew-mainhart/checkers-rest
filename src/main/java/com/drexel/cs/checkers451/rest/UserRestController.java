package com.drexel.cs.checkers451.rest;

import com.drexel.cs.checkers451.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"localhost:4200", "http://localhost:8080", "http://localhost:4200", "https://www.checkers451.com", "https://checkers451.com"}, allowCredentials = "true")
public class UserRestController {

    @GetMapping(path = "/rest/get-user")
    public User getUser(@SessionAttribute(name = "user") User user){
        return user;
    }

    @PostMapping(path = "/rest/set-user")
    public void setUser(@RequestBody() User user, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("user", user);
        response.setStatus(200);
    }

}
