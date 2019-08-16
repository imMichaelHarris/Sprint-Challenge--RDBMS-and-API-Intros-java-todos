package com.lambdaschool.todos.todos.controllers;

import com.lambdaschool.todos.todos.models.User;
import com.lambdaschool.todos.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URISyntaxException;

@RestController
@PreAuthorize("hasRole('admin')")
@RequestMapping(value = "/users")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewUser(HttpServletRequest request, @Valid @RequestBody User newUser) throws URISyntaxException {
        newUser = userService.save(newUser);
        HttpHeaders responseHeaders = new HttpHeaders();


        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);


    }
}
