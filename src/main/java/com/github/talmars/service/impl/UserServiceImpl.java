package com.github.talmars.service.impl;

import com.github.talmars.dto.UserRegistrationDTO;
import com.github.talmars.model.Tweet;
import com.github.talmars.model.User;
import com.github.talmars.repository.UserRepository;
import com.github.talmars.service.TweetService;
import com.github.talmars.service.UserService;
import com.github.talmars.util.FormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created by vladislav on 30.04.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetService tweetService;

    @Override
    public User createUser(UserRegistrationDTO userRegistrationDTO) {
        User user = FormMapper.userRegistrationDTOToUser(userRegistrationDTO);

        return userRepository.save(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }


}
