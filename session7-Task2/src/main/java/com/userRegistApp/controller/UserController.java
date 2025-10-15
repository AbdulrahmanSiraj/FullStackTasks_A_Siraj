package com.userRegistApp.controller;

import com.userRegistApp.dao.UserDAO;
import com.userRegistApp.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/")
    public String showRegistrationPage() {
        return "registPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String birthdate = request.getParameter("birthdate");
        String city = request.getParameter("city");

        User user = new User(firstName, lastName, email, birthdate, city);
        UserDAO dao = new UserDAO();
        boolean isSaved = dao.saveUser(user);

        if (isSaved) {
            model.addAttribute("message", "Data submitted successfully!");
        } else {
            model.addAttribute("message", "Failed to save data. Try again.");
        }

        return "confirmationPage";
    }
}
