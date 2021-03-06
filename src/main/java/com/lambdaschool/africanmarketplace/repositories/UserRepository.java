package com.lambdaschool.africanmarketplace.repositories;

import com.lambdaschool.africanmarketplace.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository
    extends CrudRepository<User, Long>
{
    /**
     * Find a user based off over username
     *
     * @param username the name (String) of user you seek
     * @return the first user object with the name you seek
     */
    User findByUsername(String username);

    /**
     * Find all users whose name contains a given substring ignoring case
     *
     * @param name the substring of the names (String) you seek
     * @return List of users whose name contain the given substring ignoring case
     */
    List<User> findByUsernameContainingIgnoreCase(String name);
}