package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.repository.BaseRepositoryImpl;
import com.atlantbh.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByEmail(username);
            return user;
        } catch (RepositoryException e) {
            throw new UsernameNotFoundException("This email was not found!" + username);
        }
    }

    @Transactional
    public User loadUserById(Long id) throws RepositoryException {
        User user = userRepository.get(id);
        if (user == null) new RepositoryException("User not found");
        return user;
    }
}