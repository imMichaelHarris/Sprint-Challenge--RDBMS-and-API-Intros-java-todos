package com.lambdaschool.todos.todos.services;

import com.lambdaschool.todos.todos.models.Todo;
import com.lambdaschool.todos.todos.repos.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService{

    @Autowired
    private ToDoRepository todorepos;

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findTodoById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Todo save(Todo todo) {
        return null;
    }
}
