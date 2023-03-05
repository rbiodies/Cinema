package edu.school21.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/panel")
    public String newAdminForm() {
        return "admin_panel";
    }
}
