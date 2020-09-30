package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.model.dto.JWTLoginSucessResponse;
import com.atlantbh.auction.model.dto.LoginRequest;
import com.atlantbh.auction.model.dto.RegisterRequest;
import com.atlantbh.auction.security.JwtTokenProvider;
import com.atlantbh.auction.service.MapValidationErrorService;
import com.atlantbh.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static com.atlantbh.auction.security.JwtProperties.TOKEN_PREFIX;


/**
 * controller used for user creation..
 *
 * @author Harun Hasic
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users")
public class UserController extends BaseController<User, Long, UserService> {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JWTLoginSucessResponse(true, jwt));
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterRequest user) {
        try {
            User newUser = new User(user.getFirstName(), user.getLastName(),
                    user.getEmail(), user.getPassword());
            userService.register(newUser);
            return ResponseEntity.ok(newUser);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Transactional
    @GetMapping
    @ResponseBody
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(userService.getAll());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
