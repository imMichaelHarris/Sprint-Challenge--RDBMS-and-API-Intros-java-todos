package com.lambdaschool.todos.todos.controllers;

import com.lambdaschool.todos.todos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('user') or hasRole('admin')")
@RequestMapping("/user")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "mine", produces = {"application/json"})

}
