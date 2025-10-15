package com.ageCalcApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHomePage() {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {

        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        LocalDate birthDate = LocalDate.of(year, month, day);
        Period period = Period.between(birthDate, LocalDate.now());

        model.addAttribute("year", period.getYears());
        model.addAttribute("month", period.getMonths());
        model.addAttribute("day", period.getDays());

        return "resultPage";
    }
}
