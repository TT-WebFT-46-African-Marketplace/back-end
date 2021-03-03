package com.lambdaschool.africanmarketplace.services;

import com.lambdaschool.africanmarketplace.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findRoleById(long id);

    Role save(Role role);

    Role findByName(String name);

    public void deleteAll();

    Role update(long id, Role role);
}
