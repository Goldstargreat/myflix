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

    // 특정 영화의 모든 리뷰
    public List<Review> getReviewsByMovie(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    // 특정 유저의 모든 리뷰
    public List<Review> getReviewsByUser(String username) {
        return reviewRepository.findByUsername(username);
    }

    // 유저가 특정 영화에 쓴 리뷰
    public Optional<Review> getMyReview(Long movieId, String username) {
        return reviewRepository.findByMovieIdAndUsername(movieId, username);
    }

    // 리뷰 저장 (작성 or 수정) - comment 150자 제한
    public Review saveReview(Long movieId, String username, double myRating, String comment) {
        if (comment != null && comment.length() > 150) {
            comment = comment.substring(0, 150);
        }

        Optional<Review> existing = reviewRepository.findByMovieIdAndUsername(movieId, username);
        Review review = existing.orElse(new Review());
        review.setMovieId(movieId);
        review.setUsername(username);
        review.setMyRating(myRating);
        review.setComment(comment);
        return reviewRepository.save(review);
    }

    // 리뷰 삭제 (본인 것만)
    public boolean deleteReview(Long reviewId, String username) {
        // 본인 리뷰인지 확인
        List<Review> myReviews = reviewRepository.findByUsername(username);
        for (Review r : myReviews) {
            if (r.getId().equals(reviewId)) {
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }
        return false; // 권한 없음
    }
}