package kr.ac.kopo.gnuyog.myflix.controller;

import kr.ac.kopo.gnuyog.myflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "index";
    }
}
