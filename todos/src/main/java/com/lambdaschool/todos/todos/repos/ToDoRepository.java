package com.lambdaschool.todos.todos.repos;

import com.lambdaschool.todos.todos.models.Todo;
import com.lambdaschool.todos.todos.view.TodoList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface ToDoRepository extends CrudRepository<Todo, Long> {
//
        @Query(value = "SELECT u.username as user, count(t.todoid) as todocount, t.description as desc FROM USERS u JOIN TODOS t ON u.userid = t.userid GROUP BY t.description", nativeQuery = true)
        ArrayList<TodoList> getDesc();


//    SELECT u.username as user, u.password as pass, u.USERID as userid, t.description as desc, t.completed as completed, t.todoid as todoid
//    FROM USERS u JOIN TODOS t
//    ON u.userid = t.userid
//    GROUP BY t.description
}
