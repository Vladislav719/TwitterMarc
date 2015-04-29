package com.github.talmars.repository;

import com.github.talmars.model.TweetThemeLink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladislav on 28.04.2015.
 */
@Repository
public interface TweetThemeLinkRepository extends CrudRepository<TweetThemeLink, Long> {

}
