package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping
    public String halls(Model model) {
        List<Hall> halls = hallService.findAll();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @RequestMapping("/new")
    public String newHallForm(Model model) {
        Hall hall = new Hall();
        model.addAttribute("hall", hall);
        return "new_hall";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String newHallSave(@ModelAttribute("hall") Hall hall) {
        hallService.save(hall);
        return "redirect:/admin/panel/halls";
    }

    @RequestMapping("/edit")
    public ModelAndView editHallForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_hall");
        Hall hall = hallService.findById(id);
        mav.addObject("hall", hall);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteHall(@RequestParam long id) {
        sessionService.deleteByHallId(id);
        hallService.deleteById(id);
        return "redirect:/admin/panel/halls";
    }

    @RequestMapping("/search")
    public ModelAndView searchHallForm(@RequestParam String keyword) {
        List<Hall> halls = hallService.search(keyword);
        ModelAndView mav = new ModelAndView("search_hall");
        mav.addObject("halls", halls);

        return mav;
    }
}
