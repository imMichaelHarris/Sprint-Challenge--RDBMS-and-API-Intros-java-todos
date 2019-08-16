package com.lambdaschool.todos.todos.repos;

import com.lambdaschool.todos.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo, Long> {

}
