package com.lambdaschool.todos.todos.controllers;

import com.lambdaschool.todos.todos.models.Todo;
import com.lambdaschool.todos.todos.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PutMapping(value = "/todos/todoid/{todoid", produces = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long id){
       Todo updated =  todoService.update(id, updateTodo);
       return  new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
