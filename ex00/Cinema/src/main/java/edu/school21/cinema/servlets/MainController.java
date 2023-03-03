package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/new")
    public String signUp(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "signUp";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/signIn";
    }

    @RequestMapping("/form")
    public String signIn() {
        return "signIn";
    }
}
