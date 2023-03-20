package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class CinemaController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping
    public String sessions(Model model) {
        List<Session> sessions = sessionService.findAll();
        model.addAttribute("sessions", sessions);
        return "cinema";
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Session> searchSessionForm(@RequestParam String filmName) {
        System.out.println(filmName);
        System.out.println(sessionService.findByFilmName(filmName).size());
        return sessionService.findByFilmName(filmName);
    }

    @RequestMapping("/{sessionId}")
    public ModelAndView showMovie(@PathVariable("sessionId") Long sessionId) {
        ModelAndView mav = new ModelAndView("movie");
        Session session = sessionService.findById(sessionId);
        mav.addObject("session", session);

        return mav;
    }
}
