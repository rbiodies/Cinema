package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/panel/films")
public class FilmController {

    @Value("${storage.path}")
    private String myProperty;

    @Autowired
    private FilmService filmService;

    @RequestMapping
    public ModelAndView films() {
        List<Film> listFilm = filmService.findAll();
        ModelAndView mav = new ModelAndView("films");
        mav.addObject("listFilm", listFilm);
        return mav;
    }

    @RequestMapping("/new")
    public String newFilmForm(Map<String, Object> model) {
        Film film = new Film();
        model.put("film", film);
        return "new_film";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFilm(@ModelAttribute("film") Film film,
                           @RequestParam("poster") MultipartFile poster,
                           Model model) throws IOException {
        film.setPoster(poster.getBytes());
        filmService.save(film);
        model.addAttribute("film", film);
        return "redirect:/admin/panel/films";
    }

    @RequestMapping("/showPic/{fileName}.{suffix}")
    public void showPicture(@PathVariable("fileName") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response){
        File imgFile = new File(System.getProperty("user.dir") + File.separator + myProperty + File.separator + fileName + "." + suffix);
        responseFile(response, imgFile);
    }

    private void responseFile(HttpServletResponse response, File imgFile) {
        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream()) {
            byte [] buffer = new byte [1024];
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @RequestMapping("/edit")
    public ModelAndView editCustomerForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("edit_film");
        Film film = filmService.findById(id);
        mav.addObject("film", film);

        return mav;
    }

    @RequestMapping("/delete")
    public String deleteCustomerForm(@RequestParam long id) {
        filmService.deleteById(id);
        return "redirect:/admin/panel/films";
    }

    @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Film> result = filmService.search(keyword);
        ModelAndView mav = new ModelAndView("search_film");
        mav.addObject("result", result);

        return mav;
    }
}
