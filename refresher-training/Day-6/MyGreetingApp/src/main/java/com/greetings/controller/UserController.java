package com.greetings.controller;

import com.greetings.model.User;
import com.greetings.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    // ==========================================
    // VIEW ALL USERS
    // ==========================================

    @GetMapping("/users")
    public String showUsers(
            HttpSession session,
            Model model) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "users",
                userService.getAllUsers()
        );

        return "users";
    }


    // ==========================================
    // SHOW EDIT PAGE
    // ==========================================

    @GetMapping("/edit/{id}")
    public String showEditPage(
            @PathVariable("id") int id,
            HttpSession session,
            Model model) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        User user =
                userService.getUserById(id);

        if (user == null) {
            return "redirect:/users";
        }

        model.addAttribute(
                "user",
                user
        );

        return "edit-user";
    }


    // ==========================================
    // UPDATE USER
    // ==========================================

    @PostMapping("/update")
    public String updateUser(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        User user =
                new User(
                        id,
                        name,
                        email,
                        password
                );

        userService.updateUser(user);


        // Update session if the logged-in user
        // modified their own information

        if (loggedInUser.getId() == id) {

            session.setAttribute(
                    "loggedInUser",
                    user);
        }

        return "redirect:/users";
    }


    // ==========================================
    // DELETE USER
    // ==========================================

    @GetMapping("/delete/{id}")
    public String deleteUser(
            @PathVariable("id") int id,
            HttpSession session) {

        User loggedInUser =
                (User) session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            return "redirect:/login";
        }

        userService.deleteUser(id);


        // If logged-in user deletes their own account

        if (loggedInUser.getId() == id) {

            session.invalidate();

            return "redirect:/login";
        }

        return "redirect:/users";
    }
}