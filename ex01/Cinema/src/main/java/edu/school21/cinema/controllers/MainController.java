package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.DataService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Controller
public class MainController {
    private static final String LOCALHOST_v6 = "0:0:0:0:0:0:0:1";
    private static final String LOCALHOST_v4 = "127.0.0.1";

    @Autowired
    private UserService userService;
    @Autowired
    private DataService dataService;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/new")
    public String signUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signUp";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String signUpSave(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/form";
    }

    @RequestMapping("/form")
    public String signInForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signIn";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String signInSearch(HttpServletRequest request, User userModel) {
        if (Objects.equals(userModel.getEmail(), "admin") && Objects.equals(userModel.getPassword(), "admin")) {
            return "admin";
        }
        User user = userService.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if (user != null) {
            return "redirect:/form";
        }
        request.getSession().setAttribute("user", user);
        dataService.save(new Data(user, getClientDate(), getClientTime(), getClientIP(request)));

        return "redirect:/client";
    }

    private String getClientDate() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy").withLocale(Locale.ENGLISH);
        return now.format(formatter);
    }

    private String getClientTime() {
        LocalTime now = LocalTime.now();
        return now.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-FORWARDED-FOR");

        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals(LOCALHOST_v6)) {
            ip = LOCALHOST_v4;
        }
        return ip;
    }
}
