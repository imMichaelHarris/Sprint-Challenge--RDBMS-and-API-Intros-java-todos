package com.lambdaschool.todos.todos.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('admin')")
@RequestMapping(value = "/users")
public class AdminController {
}
