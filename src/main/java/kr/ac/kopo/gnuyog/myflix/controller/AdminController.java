package kr.ac.kopo.gnuyog.myflix.controller;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String adminMain(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "admin/index";
    }

    @GetMapping("/movie/add")
    public String addMovieForm() { return "admin/movie-form"; }

    @PostMapping("/movie/add")
    public String addMovie(@RequestParam String title, @RequestParam String genre,
                           @RequestParam String description, @RequestParam String thumbnailUrl,
                           @RequestParam int releaseYear, @RequestParam double rating) {
        Movie movie = new Movie();
        movie.setTitle(title); movie.setGenre(genre);
        movie.setDescription(description); movie.setThumbnailUrl(thumbnailUrl);
        movie.setReleaseYear(releaseYear); movie.setRating(rating);
        movieService.saveMovie(movie);
        return "redirect:/admin";
    }

    @PostMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/admin";
    }
}