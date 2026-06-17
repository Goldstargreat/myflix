package kr.ac.kopo.gnuyog.myflix.service;

import kr.ac.kopo.gnuyog.myflix.model.Review;
import kr.ac.kopo.gnuyog.myflix.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public List<Review> getReviewsByUser(String username) {
        return reviewRepository.findByUsername(username);
    }

    public Optional<Review> getMyReview(Long movieId, String username) {
        return reviewRepository.findByMovieIdAndUsername(movieId, username);
    }

    public Review saveReview(Long movieId, String username, double myRating, String comment) {
        if (comment != null && comment.length() > 150)
            comment = comment.substring(0, 150);
        Review review = new Review();
        review.setMovieId(movieId);
        review.setUsername(username);
        review.setMyRating(myRating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, String username, double myRating, String comment) {
        if (comment != null && comment.length() > 150)
            comment = comment.substring(0, 150);
        for (Review r : reviewRepository.findByUsername(username)) {
            if (r.getId().equals(reviewId)) {
                r.setMyRating(myRating);
                r.setComment(comment);
                return reviewRepository.save(r);
            }
        }
        return null;
    }

    /** 본인 리뷰 삭제 (소유자 확인) */
    public boolean deleteReview(Long reviewId, String username) {
        for (Review r : reviewRepository.findByUsername(username)) {
            if (r.getId().equals(reviewId)) {
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }
        return false;
    }

    // ── 관리자 전용 ──────────────────────────────────

    /** 전체 리뷰 목록 */
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /** 관리자 강제 삭제 (소유자 체크 없음) */
    public void deleteReviewById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}