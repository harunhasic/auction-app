package com.atlantbh.auction.controller;

import com.atlantbh.auction.model.User;
import com.atlantbh.auction.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController extends BaseController<User,Long, UserService>{

}
