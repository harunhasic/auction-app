package com.atlantbh.auction.repository;

import com.atlantbh.auction.model.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository extends BaseRepositoryImpl<User, Long> {

    public UserRepository(){
        super(User.class);
    }

}
