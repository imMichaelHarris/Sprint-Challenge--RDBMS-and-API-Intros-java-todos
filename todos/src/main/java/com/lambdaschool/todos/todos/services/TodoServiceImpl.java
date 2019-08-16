package com.lambdaschool.todos.todos.services;

import com.lambdaschool.todos.todos.models.Todo;
import com.lambdaschool.todos.todos.repos.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
    public List<Todo> findAllTodosByUser(long id) throws EntityNotFoundException {
//
//        if(todos == null){
//            throw new EntityNotFoundException("User doesn't have any todos.");
//        }
//        return todorepos.getTodoList();
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    @Transactional
    public Todo save(long id, Todo todo) {
        Todo newTodo = new Todo();

        newTodo.setDescription(todo.getDescription());
        return todorepos.save(newTodo);
    }

    @Override
    @Transactional
    public Todo update(long todoId, Todo todo) {
        Todo newTOdo = todorepos.findById(todoId).orElseThrow(() -> new EntityNotFoundException(Long.toString(todoId)));

        if (todo.getDescription() != null)
        {
            newTOdo.setDescription(todo.getDescription());
        }

        if (todo.getUser() != null)
        {
            newTOdo.setUser(todo.getUser());
        }
        return todorepos.save(newTOdo);
    }
}
