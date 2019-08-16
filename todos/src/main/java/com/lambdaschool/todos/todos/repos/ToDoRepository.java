package com.lambdaschool.todos.todos.repos;

import com.lambdaschool.todos.todos.models.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<Todo, Long> {
//    @Query(value = )
//    List<>
}
