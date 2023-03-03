package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.models.Hall;
import edu.school21.cinema.services.HallService;
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
@RequestMapping("/admin/panel/halls")
public class HallController {

    @Autowired
    private HallService hallService;

    @RequestMapping
    public ModelAndView halls() {
        List<Hall> listHall = hallService.findAll();
        ModelAndView mav = new ModelAndView("halls");
        mav.addObject("listHall", listHall);
        return mav;
    }

    @RequestMapping("/new")
    public String newHallForm(Map<String, Object> model) {
        Hall hall = new Hall();
        model.put("hall", hall);
        return "new_hall";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveHall(@ModelAttribute("hall") Hall hall) {
        hallService.save(hall);
        return "redirect:/admin/panel/halls";
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_hall");
        Hall hall = hallService.findById(id);
        mav.addObject("hall", hall);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        hallService.deleteById(id);
        return "redirect:/admin/panel/halls";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Hall> result = hallService.search(keyword);
        ModelAndView mav = new ModelAndView("search_hall");
        mav.addObject("result", result);

        return mav;
    }
}
