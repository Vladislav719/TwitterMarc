package com.github.talmars.model;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by vladislav on 28.04.2015.
 */
@Entity
@Table(name = "USERS")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;
    
    private String password;

    @Column(name = "login")
    private String login;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Tweet> tweets;

    public Set<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Set<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id) &&
                Objects.equal(password, user.password) &&
                Objects.equal(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, password, login);
    }
}
