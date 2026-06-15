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

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyPageController {

    @Autowired private MovieService movieService;
    @Autowired private ReviewService reviewService;
    @Autowired private WishListService wishListService;

    // ── 마이페이지 ──────────────────────────────────────────
    @GetMapping("/mypage")
    public String myPage(Authentication auth, Model model) {
        String username = auth.getName();

        // 찜한 영화 목록
        List<Long> wishedIds = wishListService.getWishedMovieIds(username);
        List<Movie> wishedMovies = new ArrayList<>();
        for (Long id : wishedIds) {
            movieService.getMovieById(id).ifPresent(wishedMovies::add);
        }

        // 내가 쓴 리뷰 목록
        List<Review> myReviews = reviewService.getReviewsByUser(username);

        // 리뷰에 영화 제목 붙이기 위해 영화 목록도 전달
        model.addAttribute("username", username);
        model.addAttribute("wishedMovies", wishedMovies);
        model.addAttribute("myReviews", myReviews);
        model.addAttribute("allMovies", movieService.getAllMovies()); // 제목 조회용
        return "mypage";
    }

    // ── 찜 토글 (POST → redirect) ───────────────────────────
    @PostMapping("/wish/toggle/{movieId}")
    public String toggleWish(@PathVariable Long movieId, Authentication auth) {
        wishListService.toggle(auth.getName(), movieId);
        return "redirect:/movies/" + movieId;
    }

    // ── 리뷰 작성 / 수정 ────────────────────────────────────
    @PostMapping("/review/save/{movieId}")
    public String saveReview(@PathVariable Long movieId,
                             @RequestParam double myRating,
                             @RequestParam String comment,
                             Authentication auth) {
        reviewService.saveReview(movieId, auth.getName(), myRating, comment);
        return "redirect:/movies/" + movieId;
    }

    // ── 리뷰 삭제 ───────────────────────────────────────────
    @PostMapping("/review/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId,
                               @RequestParam Long movieId,
                               Authentication auth) {
        reviewService.deleteReview(reviewId, auth.getName());
        return "redirect:/movies/" + movieId;
    }
}