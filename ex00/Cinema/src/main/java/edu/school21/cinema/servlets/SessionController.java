package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/panel/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping
    public ModelAndView sessions() {
        List<Session> listSession = sessionService.findAll();
        ModelAndView mav = new ModelAndView("sessions");
        mav.addObject("listSession", listSession);
        return mav;
    }

    @RequestMapping("/new")
    public String newSessionForm(Map<String, Object> model) {
        Session session = new Session();
        model.put("session", session);
        return "new_session";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSession(@ModelAttribute("session") Session session) {
        sessionService.save(session);
        return "redirect:/admin/panel/sessions";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_session");
        Session session = sessionService.findById(id);
        mav.addObject("session", session);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        sessionService.deleteById(id);
        return "redirect:/admin/panel/sessions";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Session> result = sessionService.search(keyword);
        ModelAndView mav = new ModelAndView("search_session");
        mav.addObject("result", result);

        return mav;
    }
}
