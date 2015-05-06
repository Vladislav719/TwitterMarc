package com.github.talmars.controller;

import com.github.talmars.config.*;
import com.github.talmars.dto.TweetDTO;
import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import com.github.talmars.repository.UserRepository;
import com.github.talmars.service.TweetService;
import com.github.talmars.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by vladislav on 06.05.2015.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
////@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {CoreConfig.class, DataSourceConfig.class, PersistenceConfig.class, WebConfig.class, WebAppInitializer.class})
public class AppTest {

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @Test
    public void testRegisterUser() throws Exception {

        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setPassword("123");
        userRegistrationDTO.setLogin("123");

        User user = userService.createUser(userRegistrationDTO);
        assertNotNull(user);

    }

    @Test
    public void testLoadUser() throws Exception {


        User user = userService.getUserByLogin("Marcel");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getLogin(), "Marcel");
    }

    @Test

    public void testTweetGetInfo() throws Exception {
        Tweet tweet = tweetService.getTweetInfo(1);
        Assert.assertNotNull(tweet);
    }

    @Test

    public void testCreateTweet() throws Exception {
        TweetDTO tweetDTO = new TweetDTO();
        tweetDTO.setText("aaa");
        User user = new User();
        user.setId(1l);


        Tweet tweet = tweetService.writeTweet(tweetDTO, user);

        Assert.assertNotNull(tweet);
    }

    @Test
    public void testDeleteTweet() throws Exception {
        boolean deleted = tweetService.deleteTweet(1);
        Assert.assertTrue(deleted);
    }

    @Test
    public void testGetAllTweets() throws Exception {
        Assert.assertNotNull(tweetService.getAllTweets());
    }

    @Test
    public void testGetAllTweetThisUser() throws Exception {
        User user = new User();
        user.setId(1l);
        Assert.assertNotNull(tweetService.getAllTweetsThisUser(user));
    }

    @Test
    public void testUpdateTweet() throws Exception{

        Tweet tweet1 = new Tweet();
        tweet1.setText("11");
        tweet1.setId(1l);
        User user = new User();
        user.setId(1l);
        tweet1.setOwner(user);
        tweet1.setCreatedAt(new Date());
        Tweet tweet = tweetService.updateTweet(tweet1);
        Assert.assertNotNull(tweet);
    }




}