package com.greetings.service;

import com.greetings.dao.UserDAO;
import com.greetings.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;


    
    // CREATE - REGISTER USER
   
    public boolean registerUser(User user) {

        return userDAO.registerUser(user);
    }


   
    // READ - CHECK IF EMAIL EXISTS

    public boolean emailExists(String email) {

        return userDAO.emailExists(email);
    }


    // READ - LOGIN

    public User login(
            String email,
            String password) {

        return userDAO.login(
                email,
                password
        );
    }


    // READ - GET ALL USERS

    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }


    // READ - GET USER BY ID

    public User getUserById(int id) {

        return userDAO.getUserById(id);
    }


    // UPDATE - UPDATE USER
    
    public boolean updateUser(User user) {

        return userDAO.updateUser(user);
    }


 
    // DELETE - DELETE USER

    public boolean deleteUser(int id) {

        return userDAO.deleteUser(id);
    }
}