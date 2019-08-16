package com.lambdaschool.todos.todos.repos;

import com.lambdaschool.todos.todos.models.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<Todo, Long> {
        List<Todo> findByUserId(long id);
//    @Query(value = )
//    List<>

//    SELECT u.username as user, u.password as pass, u.USERID as userid, t.description as desc, t.completed as completed, t.todoid as todoid
//    FROM USERS u JOIN TODOS t
//    ON u.userid = t.userid
//    GROUP BY t.description
}
