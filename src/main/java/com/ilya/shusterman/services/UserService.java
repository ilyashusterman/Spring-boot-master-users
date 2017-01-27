package com.ilya.shusterman.services;

import com.ilya.shusterman.beans.User;
import com.ilya.shusterman.controller.ExceptionHandlingController;
import com.ilya.shusterman.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.util.zip.DataFormatException;

/**
 * Created by ilya on 26/01/2017.
 */
@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) throws DataFormatException {
        logger.debug(" userrepository  ",userRepository);
        logger.debug("username",username,"userRepository "+userRepository.findByUserName(username));
        User user = userRepository.findByUserName(username);
       if((user==null) || (user!=null&&!user.getPassword().equals(password))) {
          throw new DataFormatException("username and password doesn't match!");
       }
       return user;
    }
}
