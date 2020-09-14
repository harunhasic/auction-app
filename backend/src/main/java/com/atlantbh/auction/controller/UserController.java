package com.atlantbh.auction.controller;

import com.atlantbh.auction.model.User;
import com.atlantbh.auction.service.BaseService;
import com.atlantbh.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController extends BaseController<User>{

    @Autowired
    protected UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }
}
