package com.github.talmars.controller;

import com.github.talmars.dto.TweetDTO;
import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import com.github.talmars.service.TweetService;
import com.github.talmars.service.UserService;
import com.github.talmars.util.SecurityContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by vladislav on 28.04.2015.
 */
@Controller
@RequestMapping(value = "/app/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public String getAllTweets(Model model) {
        System.out.println(tweetService.getAllTweets());
        model.addAttribute("allT", true);
        model.addAttribute("tweetsAll", tweetService.getAllTweets());
        return "tweet";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/owner/{name}")
    public String getAllTweetsThisUser(Model model, @PathVariable String name) {

        model.addAttribute("byUser", true);
//        just for test
        User user = userService.getUserByLogin(name);
        if (user == null) {
            model.addAttribute("error", "user not found");
            return "tweet";
        }
        List<Tweet> tweetList = tweetService.getAllTweetsThisUser(user);
        model.addAttribute("tweetsUser", tweetList);
        return "tweet";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getTweetInfo(Model model, @PathVariable long id) {
        Tweet tweet = tweetService.getTweetInfo(id);
        model.addAttribute("tweet", tweet);
        return "tweet";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void writeTweet(Model model, TweetDTO tweetDTO, HttpServletRequest request) {
        User user = new SecurityContextUtil(userService).getCurrentUser();
//        user.setId(1l);
        Tweet tweet = tweetService.writeTweet(tweetDTO, user);
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
        User user = new SecurityContextUtil(userService).getCurrentUser();
        Tweet tweet = tweetService.getTweetInfo(id);
        boolean isOK = tweet.getOwner().equals(user);
        if (isOK)
            model.addAttribute("isRemoved" , tweetService.deleteTweet(id));
        else
            model.addAttribute("error", "you cannot delete this tweet");
        return "tweet";
    }


}
