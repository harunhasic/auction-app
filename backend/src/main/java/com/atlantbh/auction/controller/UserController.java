package com.atlantbh.auction.controller;

import com.atlantbh.auction.model.User;
import com.atlantbh.auction.service.BaseService;
import com.atlantbh.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
public class UserController extends BaseController<User>{

    @Autowired
    protected UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super(userService);
    }

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User user){
        User user1 = userService.saveOrUpdateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
