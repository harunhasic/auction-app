package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.model.dto.JWTLoginSucessResponse;
import com.atlantbh.auction.model.dto.LoginRequest;
import com.atlantbh.auction.repository.UserRepository;
import com.atlantbh.auction.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


/**
 * A service used for user business logic.
 *
 * @author Harun Hasic
 */

@Service
public class UserService extends BaseService<User, Long, UserRepository> implements UserDetailsService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${token.prefix}")
    private String tokenPrefix;


    /**
     * Method used for the registration of users.
     */
    public User register(User entity) throws ServiceException {
        try {
            if (userExists(entity.getEmail())) {
                String message = "A user with this email " + entity.getEmail() + " is already registered";
                throw new ServiceException(message);
            }
            User user = new User(entity.getFirstName(), entity.getLastName(), entity.getEmail(), new BCryptPasswordEncoder().encode(entity.getPassword()));
            return userRepository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with the registration of this user", e);
        }
    }

    public JWTLoginSucessResponse login(LoginRequest loginRequest) throws RepositoryException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenPrefix + tokenProvider.generateToken(authentication);

            return new JWTLoginSucessResponse(true, jwt);
        } catch (AuthenticationException e) {
            throw new RepositoryException("Invalid email/password supplied", e);
        }
    }

    /**
     * Method that checks if the use already exists by checking the email.
     */

    private boolean userExists(String email) throws ServiceException {
        try {
            repository.findByEmail(email);

        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with finding this email", e);
        }
        return true;
    }

    public User findByEmail(String email) throws ServiceException {
        try {
            Optional<User> user = userRepository.findByEmail(email);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new ServiceException("There was an issue with finding this user");
            }
        } catch (RepositoryException e) {
            throw new ServiceException("This email was not found", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByEmail(username).get();
            return user;
        } catch (RepositoryException e) {
            throw new UsernameNotFoundException("This email was not found!" + username);
        }
    }

    @Transactional
    public User loadUserById(Long id) throws RepositoryException {
        User user = repository.get(id);
        if (user == null) new RepositoryException("User not found");
        return user;
    }
}

