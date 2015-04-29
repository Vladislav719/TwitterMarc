package com.github.talmars.service.impl;

import com.github.talmars.dto.TweetDTO;
import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import com.github.talmars.repository.TweetRepository;
import com.github.talmars.service.TweetService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by vladislav on 28.04.2015.
 */
@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public List<Tweet> getAllTweets() {
        return Lists.newArrayList(tweetRepository.findAll());
    }

    @Override
    public List<Tweet> getAllTweetsThisUser(User user) {
        return Lists.newArrayList(tweetRepository.getAllTweetsThisUser(user.getId()));
    }

    @Override
    public Tweet getTweetInfo(long id) {
        return tweetRepository.findOne(id);
    }

    @Override
    public Tweet writeTweet(TweetDTO tweetDTO, User user) {

        Tweet tweet = new Tweet();
        tweet.setCreatedAt(new Date());
        tweet.setOwner(user);
        tweet.setText(tweetDTO.getText());

        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {

        Tweet tweetNew = tweetRepository.findOne(tweet.getId());
        tweetNew.setText(tweet.getText());
        return tweetRepository.save(tweetNew);
    }

    @Override
    public boolean deleteTweet(long id) {

        Tweet tweet = tweetRepository.findOne(id);
        if (tweet != null){
            tweetRepository.delete(tweet);
            return true;
        }
        return false;
    }
}
