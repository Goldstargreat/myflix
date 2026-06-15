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
        return "admin_index";
    }

    // 추가 폼
    @GetMapping("/movie/add")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("isEdit", false);
        return "admin/movie-form";
    }

    // 추가 처리
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

    // 수정 폼
    @GetMapping("/movie/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id).orElseThrow();
        model.addAttribute("movie", movie);
        model.addAttribute("isEdit", true);
        return "admin/movie-form";
    }

    // 수정 처리
    @PostMapping("/movie/edit/{id}")
    public String editMovie(@PathVariable Long id,
                            @RequestParam String title, @RequestParam String genre,
                            @RequestParam String description, @RequestParam String thumbnailUrl,
                            @RequestParam int releaseYear, @RequestParam double rating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title); movie.setGenre(genre);
        movie.setDescription(description); movie.setThumbnailUrl(thumbnailUrl);
        movie.setReleaseYear(releaseYear); movie.setRating(rating);
        movieService.saveMovie(movie);
        return "redirect:/admin";
    }

    // 삭제
    @PostMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/admin";
    }
}