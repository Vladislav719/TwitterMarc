package com.github.talmars.controller;

import com.github.talmars.dto.TweetDTO;
import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import com.github.talmars.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by vladislav on 28.04.2015.
 */
@Controller
@RequestMapping(value = "/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String getAllTweets(Model model) {
        System.out.println(tweetService.getAllTweets());
        model.addAttribute("tweets", tweetService.getAllTweets());
        return "tweet";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/owner/{id}")
    public String getAllTweetsThisUser(Model model, @PathVariable Long id){

//        just for test
        User user = new User();
        user.setId(id);

        List<Tweet> tweetList = tweetService.getAllTweetsThisUser(user);
        model.addAttribute("tweets",  tweetList);
        return "tweet";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getTweetInfo(Model model, @PathVariable long id) {
        Tweet tweet = tweetService.getTweetInfo(id);
        model.addAttribute("tweet", tweet);
        return "tweet";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String writeTweet(Model model, TweetDTO tweetDTO) {
        User user = new User();
        user.setId(1l);
        Tweet tweet = tweetService.writeTweet(tweetDTO, user);
        System.out.println("??? ?? ?????? ???? " + tweet);
        model.addAttribute("tweetNew", tweet);
        return "tweet";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{/id}")
    public String updateTweet(Model model,@PathVariable long id, @RequestBody TweetDTO tweetDTO) {
        Tweet tweet = tweetService.getTweetInfo(id);
        tweet.setText(tweetDTO.getText());
        tweet =  tweetService.updateTweet(tweet);
        model.addAttribute("upTweet", tweet);


        return "tweet";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String deleteTweet(Model model, @PathVariable long id) {

        // TODO: ???????? ???????? ?????? ???? ?? ??? ?????? ????? ???????? ??????? ??????
        model.addAttribute("isRemoved" , tweetService.deleteTweet(id));
        return "tweet";
    }


}
