package com.student.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.model.Student;
import com.student.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {

        this.studentService = studentService;

    }


    // REGISTER - SHOW PAGE
   
    @GetMapping("/register")
    public String showRegisterPage() {

        return "register";

    }


   
    // REGISTER - CREATE
    

    @PostMapping("/register")
    public String registerStudent(
            @ModelAttribute Student student,
            Model model) {

        studentService.registerStudent(student);

        model.addAttribute("student", student);

        return "registration-success";

    }


    
    // LOGIN - SHOW PAGE

    @GetMapping("/login")
    public String showLoginPage() {

        return "login";

    }


    
    // LOGIN

    @PostMapping("/login")
    public String loginStudent(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {


        Student student =
                studentService.loginStudent(email, password);


        if (student != null) {

            session.setAttribute("student", student);

            return "login-success";

        }


        model.addAttribute(
                "error",
                "Invalid email or password"
        );


        return "login";

    }


    // READ - SHOW ALL STUDENTS
    
    @GetMapping("/students")
    public String viewStudents(Model model) {

        List<Student> students =
                studentService.getAllStudents();

        model.addAttribute("students", students);

        return "students";

    }


    
    // UPDATE - SHOW EDIT PAGE
    

    @GetMapping("/student/edit")
    public String showEditStudentPage(
            @RequestParam("id") int id,
            Model model) {


        Student student =
                studentService.getStudentById(id);


        model.addAttribute("student", student);

        return "edit-student";

    }


        // UPDATE - SAVE CHANGES
    
    @PostMapping("/student/update")
    public String updateStudent(
            @ModelAttribute Student student) {


        studentService.updateStudent(student);


        return "redirect:/students";

    }


   
    // DELETE
   
    @GetMapping("/student/delete")
    public String deleteStudent(
            @RequestParam("id") int id) {


        studentService.deleteStudent(id);


        return "redirect:/students";

    }


  
    // LOGOUT


    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";

    }

}