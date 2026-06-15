package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    List<Review> findByMovieId(Long movieId);           // 특정 영화의 모든 리뷰
    List<Review> findByUsername(String username);        // 특정 유저의 모든 리뷰
    Optional<Review> findByMovieIdAndUsername(Long movieId, String username); // 유저의 특정 영화 리뷰
    Review save(Review review);
    void deleteById(Long id);
}