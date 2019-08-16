package com.lambdaschool.todos.todos.services;

import com.lambdaschool.todos.todos.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findRoleById(long id);

    void delete(long id);

    Role save(Role role);
}