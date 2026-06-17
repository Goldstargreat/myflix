package kr.ac.kopo.gnuyog.myflix.controller;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.model.Review;
import kr.ac.kopo.gnuyog.myflix.model.User;
import kr.ac.kopo.gnuyog.myflix.repository.UserRepository;
import kr.ac.kopo.gnuyog.myflix.service.MovieService;
import kr.ac.kopo.gnuyog.myflix.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private MovieService movieService;
    @Autowired private ReviewService reviewService;
    @Autowired private UserRepository userRepository;   // 회원 목록용

    /* ────────────────────────────────────────────────
       관리자 메인 (탭: 콘텐츠 / 회원 / 리뷰)
    ──────────────────────────────────────────────── */
    @GetMapping
    public String adminMain(@RequestParam(defaultValue = "movies") String tab, Model model) {
        model.addAttribute("movies",  movieService.getAllMovies());
        model.addAttribute("users",   userRepository.findAll());        // 전체 회원
        model.addAttribute("reviews", reviewService.getAllReviews());    // 전체 리뷰
        model.addAttribute("tab", tab);
        return "admin/admin_index";
    }

    /* ────────────────────────────────────────────────
       콘텐츠 CRUD
    ──────────────────────────────────────────────── */
    @GetMapping("/movie/add")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("isEdit", false);
        return "admin/movie-form";
    }

    @PostMapping("/movie/add")
    public String addMovie(@RequestParam String title, @RequestParam String genre,
                           @RequestParam String description, @RequestParam String thumbnailUrl,
                           @RequestParam int releaseYear, @RequestParam double rating) {
        Movie movie = new Movie();
        movie.setTitle(title);       movie.setGenre(genre);
        movie.setDescription(description); movie.setThumbnailUrl(thumbnailUrl);
        movie.setReleaseYear(releaseYear); movie.setRating(rating);
        movieService.saveMovie(movie);
        return "redirect:/admin?tab=movies";
    }

    @GetMapping("/movie/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id).orElseThrow();
        model.addAttribute("movie", movie);
        model.addAttribute("isEdit", true);
        return "admin/movie-form";
    }

    @PostMapping("/movie/edit/{id}")
    public String editMovie(@PathVariable Long id,
                            @RequestParam String title, @RequestParam String genre,
                            @RequestParam String description, @RequestParam String thumbnailUrl,
                            @RequestParam int releaseYear, @RequestParam double rating) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);       movie.setGenre(genre);
        movie.setDescription(description); movie.setThumbnailUrl(thumbnailUrl);
        movie.setReleaseYear(releaseYear); movie.setRating(rating);
        movieService.saveMovie(movie);
        return "redirect:/admin?tab=movies";
    }

    @PostMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/admin?tab=movies";
    }

    /* ────────────────────────────────────────────────
       회원 관리 — 강제 탈퇴(삭제)
    ──────────────────────────────────────────────── */
    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/admin?tab=users";
    }

    /* ────────────────────────────────────────────────
       리뷰 관리 — 관리자 강제 삭제
    ──────────────────────────────────────────────── */
    @PostMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReviewById(id);   // 관리자용 (소유자 체크 없음)
        return "redirect:/admin?tab=reviews";
    }
}