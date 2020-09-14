package com.atlantbh.auction.service;

import com.atlantbh.auction.model.User;
import com.atlantbh.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements BaseService<User> {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     *todo- implementations of methods
     */
    @Override
    public User getById(Long requestId) {

        return null;
    }
}
