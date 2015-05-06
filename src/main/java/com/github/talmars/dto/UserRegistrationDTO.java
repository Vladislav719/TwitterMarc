package com.github.talmars.dto;

/**
 * Created by vladislav on 30.04.2015.
 */
public class UserRegistrationDTO {

    private String password;
    private String login;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String password, String login) {
        this.password = password;
        this.login = login;
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
}
