package kr.ac.kopo.gnuyog.myflix.controller;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.model.Review;
import kr.ac.kopo.gnuyog.myflix.service.MovieService;
import kr.ac.kopo.gnuyog.myflix.service.ReviewService;
import kr.ac.kopo.gnuyog.myflix.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired private MovieService movieService;
    @Autowired private ReviewService reviewService;
    @Autowired private WishListService wishListService;

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
    public String movieDetail(@PathVariable Long id, Authentication auth, Model model) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isEmpty()) return "redirect:/movies";

        model.addAttribute("movie", movie.get());

        // 해당 영화의 모든 리뷰
        List<Review> reviews = reviewService.getReviewsByMovie(id);
        model.addAttribute("reviews", reviews);

        // 로그인한 경우 → 찜 여부 + 내 리뷰
        if (auth != null && auth.isAuthenticated()) {
            String username = auth.getName();
            model.addAttribute("isWished", wishListService.isWished(username, id));
            model.addAttribute("myReview",
                    reviewService.getMyReview(id, username).orElse(null));
            model.addAttribute("loggedIn", true);
        } else {
            model.addAttribute("isWished", false);
            model.addAttribute("myReview", null);
            model.addAttribute("loggedIn", false);
        }

        return "movie/detail";
    }
}