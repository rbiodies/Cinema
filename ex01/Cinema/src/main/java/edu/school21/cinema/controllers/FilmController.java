package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.services.FilmService;
import edu.school21.cinema.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/panel/films")
public class FilmController {

    @Value("${storage.path}")
    private String myProperty;

    @Autowired
    private FilmService filmService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping
    public String films(Model model) {
        List<Film> films = filmService.findAll();
        model.addAttribute("films", films);
        return "films";
    }

    @RequestMapping("/new")
    public String newFilmForm(Model model) {
        Film film = new Film();
        model.addAttribute("film", film);
        return "new_film";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String newFilmSave(@ModelAttribute("film") Film film,
                              @RequestParam("fileUpload") MultipartFile file) {
        if (file != null) {
            String originalFileName = file.getOriginalFilename();
            if (originalFileName != null) {
                String fileName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));
                File filePath = new File(myProperty);
                if (!filePath.exists()){
                    filePath.mkdirs();
                }
                try {
                    file.transferTo(new File(System.getProperty("user.dir") + File.separator + filePath + File.separator + fileName));
                    film.setPoster(fileName);
                    filmService.save(film);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/admin/panel/films";
    }

    @RequestMapping("/edit")
    public ModelAndView editFilmForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_film");
        Film film = filmService.findById(id);
        mav.addObject("film", film);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteFilm(@RequestParam long id) {
        sessionService.deleteByFilmId(id);
        filmService.deleteById(id);
        return "redirect:/admin/panel/films";
    }

    @RequestMapping("/search")
    public ModelAndView searchFilmForm(@RequestParam String keyword) {
        List<Film> films = filmService.search(keyword);
        ModelAndView mav = new ModelAndView("search_film");
        mav.addObject("films", films);

        return mav;
    }
}
