package com.lambdaschool.todos.todos.services;

import com.lambdaschool.todos.todos.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();

    Todo findTodoById(long id);

    List<Todo> findAllTodosByUser(long id);

    void delete(long id);

    Todo save(Todo todo);
}
