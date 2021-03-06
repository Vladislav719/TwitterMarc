package com.github.talmars.repository;

import com.github.talmars.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 28.04.2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("from User u where u.login=?1")
    public User getUserByLogin(String login);


}
