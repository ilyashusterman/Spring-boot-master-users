package com.ilya.shusterman.controller;

import com.ilya.shusterman.beans.User;
import com.ilya.shusterman.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.zip.DataFormatException;

/**
 * Created by ilya on 26/01/2017.
 */
@RestController
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void loginUser(@RequestBody User user,
                          @Autowired HttpServletRequest request, @Autowired HttpServletResponse response) throws DataFormatException {
        logger.debug("user",user);
        user = userService.login(user.getUserName(),user.getPassword());
        request.getSession(true).setAttribute("user", user);
        response.setHeader("User", request.getRequestURL().append("/").append(user.getId()).toString());
    }
    @RequestMapping(value = "/testlogin",
            method = RequestMethod.GET
            )
  public User loginUser(
            @Autowired HttpServletRequest request, @Autowired HttpServletResponse response) {
       // throw new DataFormatException("username and password doesn't match!");
            User user = new User("admin", "username" , "password");
        return user;
    }
    @RequestMapping(value = "/test",
            method = RequestMethod.GET)
    public String test(
            @Autowired HttpServletRequest request,@Autowired HttpServletResponse response) {
        // throw new DataFormatException("username and password doesn't match!");
       return "test Auth controller";
    }


}
