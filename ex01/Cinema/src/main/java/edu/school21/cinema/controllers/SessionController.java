package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/panel/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping
    public String sessions(Model model) {
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions", sessions);
        return "sessions";
    }

    @RequestMapping("/new")
    public String newSessionForm(Model model) {
        Session session = new Session();
        model.addAttribute("session", session);
        return "new_session";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String newSessionSave(@ModelAttribute("session") Session session) {
        sessionService.save(session);
        return "redirect:/admin/panel/sessions";
    }

    @RequestMapping("/edit")
    public ModelAndView editSessionForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_session");
        Session session = sessionService.findById(id);
        mav.addObject("session", session);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteSession(@RequestParam long id) {
        sessionService.deleteById(id);
        return "redirect:/admin/panel/sessions";
    }

    @RequestMapping("/search")
    public ModelAndView searchSessionForm(@RequestParam String keyword) {
        List<Session> sessions = sessionService.search(keyword);
        ModelAndView mav = new ModelAndView("search_session");
        mav.addObject("sessions", sessions);

        return mav;
    }
}
