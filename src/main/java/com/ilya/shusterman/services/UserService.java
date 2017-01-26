package com.ilya.shusterman.services;

import com.ilya.shusterman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 * Created by ilya on 26/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password){
        System.out.println(" userrepository  "+userRepository);
        System.out.println(username+"=username="+userRepository.findByUserName(username));
       if( !userRepository.findByUserName(username).getPassword().equals(password)) {
          return false; // throw new DataFormatException("ID doesn't match!");
       }
       return true;
    }
}
