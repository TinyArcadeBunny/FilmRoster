package net.javaguides.springboot.Controller;

import net.javaguides.springboot.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;
    

    //display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listFilms", filmService.getAllFilms());
        return "index";

    }
    @GetMapping("/showNewFilmForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Film film = new Film();
        model.addAttribute("film", film);
        return "new_film";
    }
    @PostMapping("/saveFilm")
    public String saveFilm(@ModelAttribute("film") Film film) {
        // save Film to database
        filmService.saveFilm(film);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get films from the service
        Film film = filmService.getFilmById(id);

        // set Film as a model attribute to pre-populate the form
        model.addAttribute("film", film);
        return "update_film";
    }
    @GetMapping("/deleteFilm/{id}")
    public String deleteFilm(@PathVariable (value = "id") long id) {

        // call delete film method
        this.filmService.deleteFilmById(id);
        return "redirect:/";
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Film> page = filmService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Film> listFilms = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listFilms", listFilms);
        return "index";
    }

}
