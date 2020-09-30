package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A service used for user business logic.
 *
 * @author Harun Hasic
 */

@Service
public class UserService extends BaseService<User, Long, UserRepository> {

    @Autowired
    protected UserRepository userRepository;

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
            return repository.save(user);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with the registration of this user");
        }
    }

    /**
     * Method used for updating the user data
     */

    @Override
    public User update(User resource) throws ServiceException {
        try {
            User userToUpdate = repository.get(resource.getId());
            resource.update(userToUpdate);
            repository.update(userToUpdate);
            return userToUpdate;
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with updating this user");
        }
    }

    /**
     * Method that checks if the use already exists by checking the email.
     */

    private boolean userExists(String email) {
        try {
            repository.findByEmail(email);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<User> getAll() throws ServiceException {
        try {
            return userRepository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("An error occured while trying to get all the objects");
        }
    }

}
