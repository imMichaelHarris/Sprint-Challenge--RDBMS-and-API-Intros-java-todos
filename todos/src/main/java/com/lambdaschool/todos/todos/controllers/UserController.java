package com.lambdaschool.todos.todos.controllers;

import com.lambdaschool.todos.todos.models.Todo;
import com.lambdaschool.todos.todos.models.User;
import com.lambdaschool.todos.todos.services.TodoService;
import com.lambdaschool.todos.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/mine", produces = {"application/json"})
    public ResponseEntity<?> getMyTodos(Authentication authentication){
        return  new ResponseEntity<>(userService.findUserByName(authentication.getName()), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newuser) throws URISyntaxException
    {
        newuser =  userService.save(newuser);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping(value = "/todo/{userid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addNewUser(@PathVariable int userid, @Valid @RequestBody Todo newTodo) throws URISyntaxException
    {
        newTodo =  todoService.save(userid, newTodo);

        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/userid/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable long userid){
        userService.delete(userid);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    }

