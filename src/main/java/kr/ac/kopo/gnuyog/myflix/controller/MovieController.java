package kr.ac.kopo.gnuyog.myflix.controller;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String movieList(@RequestParam(required = false) String genre, Model model) {
        List<Movie> movies = (genre != null && !genre.isEmpty())
                ? movieService.getMoviesByGenre(genre)
                : movieService.getAllMovies();
        model.addAttribute("movies", movies);
        model.addAttribute("selectedGenre", genre);
        return "movie/list";
    }

    @GetMapping("/{id}")
    public String movieDetail(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isEmpty()) return "redirect:/movies";
        model.addAttribute("movie", movie.get());
        return "movie/detail";
    }
}