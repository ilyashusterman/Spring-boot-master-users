package com.ilya.shusterman.controller;

import com.ilya.shusterman.beans.User;
import com.ilya.shusterman.services.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void loginUser(@RequestBody User user,
                          HttpServletRequest request, HttpServletResponse response) throws DataFormatException {
        // throw new DataFormatException("ID doesn't match!");
        System.out.println(user);
        userService.login(user.getUsername(),user.getPassword());
        response.setHeader("User", request.getRequestURL().append("/").append(user.getId()).toString());
    }
    @RequestMapping(value = "/testUser",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.ACCEPTED)
  public  User loginUser(
                          HttpServletRequest request, HttpServletResponse response) {
       // throw new DataFormatException("ID doesn't match!");
            User user = new User("admin", "username" , "password");
        return user;
    }


}
