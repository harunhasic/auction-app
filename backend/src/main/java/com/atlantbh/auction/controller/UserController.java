package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.model.dto.LoginRequest;
import com.atlantbh.auction.model.dto.LoginResponse;
import com.atlantbh.auction.model.dto.RegisterRequest;
import com.atlantbh.auction.service.UserService;
import com.atlantbh.utils.MapValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


/**
 * Controller used for model User request handling.
 * Main purpose is to register and save users.
 *
 * @author Harun Hasic
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/users")
public class UserController extends BaseController<User, Long, UserService> {


    @PostMapping("/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) throws ServiceException {
        Optional<ResponseEntity<?>> errorMap = MapValidationErrors.checkForErrors(result);
        try {
            if (errorMap != null) {
                return errorMap.isPresent()
                        ? new ResponseEntity(errorMap.get(), HttpStatus.OK)
                        : ResponseEntity.ok(service.login(loginRequest));
            }
        } catch (RepositoryException e) {
            throw new ServiceException("There was issues with authenticating this user");
        }
        return ResponseEntity.ok(new LoginResponse(loginRequest.getEmail()));
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            User newUser = new User(user);
            service.register(newUser);
            return ResponseEntity.ok(newUser);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @RequestMapping("/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(service.findByEmail(email));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
