package com.atlantbh.auction.service;

import com.atlantbh.auction.model.User;
import com.atlantbh.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<User, Long, UserRepository> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long requestId) {
        return userRepository.get(requestId);
    }

    @Override
    public void create(User obj) {
         userRepository.add(obj);
    }

    @Override
    public User update (User user) {
        return userRepository.update(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }




}
