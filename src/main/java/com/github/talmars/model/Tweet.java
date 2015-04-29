package com.github.talmars.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by vladislav on 28.04.2015.
 */
@Entity
@Table(name = "TWEETS")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_id")
    private Long id;

    @ManyToOne
    private User owner;

    private String text;

    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "tweet")
    private Set<TweetThemeLink> tweetThemeLinks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TweetThemeLink> getTweetThemeLinks() {
        return tweetThemeLinks;
    }

    public void setTweetThemeLinks(Set<TweetThemeLink> tweetThemeLinks) {
        this.tweetThemeLinks = tweetThemeLinks;
    }
}
