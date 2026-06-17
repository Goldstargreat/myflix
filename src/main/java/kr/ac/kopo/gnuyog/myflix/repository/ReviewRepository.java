package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {
    List<Review> findByMovieId(Long movieId);
    List<Review> findByUsername(String username);
    Optional<Review> findByMovieIdAndUsername(Long movieId, String username);
    Review save(Review review);
    void deleteById(Long id);

    // 관리자용
    List<Review> findAll();
}