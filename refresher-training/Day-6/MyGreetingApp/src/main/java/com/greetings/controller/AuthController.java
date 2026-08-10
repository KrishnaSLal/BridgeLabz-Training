package com.greetings.controller;

import com.greetings.model.User;
import com.greetings.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;


    // SHOW LOGIN PAGE
 

    @GetMapping("/login")
    public String showLoginPage() {

        return "login";
    }


    
    // LOGIN
   
    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        User user =
                userService.login(
                        email,
                        password
                );

        if (user != null) {

            session.setAttribute(
                    "loggedInUser",
                    user
            );

            return "redirect:/greeting";
        }

        model.addAttribute(
                "error",
                "Invalid email or password."
        );

        return "login";
    }


    
    // SHOW REGISTER PAGE
   
    @GetMapping("/register")
    public String showRegisterPage() {

        return "register";
    }


   
    // REGISTER
    

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        User user =
                new User(
                        name,
                        email,
                        password
                );

        boolean registered =
                userService.registerUser(user);

        if (registered) {

            model.addAttribute(
                    "success",
                    "Registration successful! Please login."
            );

            return "login";
        }

        model.addAttribute(
                "error",
                "Email already exists."
        );

        return "register";
    }


   
    // LOGOUT
   
    @GetMapping("/logout")
    public String logout(
            HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}