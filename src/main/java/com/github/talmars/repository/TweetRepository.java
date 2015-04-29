package com.github.talmars.repository;

import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 28.04.2015.
 */
@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {

    @Query("from Tweet t where t.owner.id=?1")
    public Iterable<Tweet> getAllTweetsThisUser(long user);
}
