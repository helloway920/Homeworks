package com.example.hw0125.Service;

import com.example.hw0125.DAO.UserDAO;
import com.example.hw0125.Domain.User;
import com.example.hw0125.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public List<User> findByName(String name) throws UserNotFoundException {
        List<User> res = userDAO.findByName(name);
        if(res.isEmpty()){
            throw new UserNotFoundException(name);
        }
        return res;
    }
}
