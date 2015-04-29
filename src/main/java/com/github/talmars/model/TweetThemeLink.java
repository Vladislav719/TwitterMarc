package com.github.talmars.model;

import javax.persistence.*;

/**
 * Created by vladislav on 28.04.2015.
 */
@Entity
@Table()
public class TweetThemeLink {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_theme_link_id")
    private Long tweetThemeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public Long getTweetThemeId() {
        return tweetThemeId;
    }

    public void setTweetThemeId(Long tweetThemeId) {
        this.tweetThemeId = tweetThemeId;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
