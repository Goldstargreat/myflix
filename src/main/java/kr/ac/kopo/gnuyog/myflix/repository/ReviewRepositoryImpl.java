package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private List<Review> reviews = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Review> findByMovieId(Long movieId) {
        List<Review> result = new ArrayList<>();
        for (Review r : reviews) {
            if (r.getMovieId().equals(movieId)) result.add(r);
        }
        return result;
    }

    @Override
    public List<Review> findByUsername(String username) {
        List<Review> result = new ArrayList<>();
        for (Review r : reviews) {
            if (r.getUsername().equals(username)) result.add(r);
        }
        return result;
    }

    @Override
    public Optional<Review> findByMovieIdAndUsername(Long movieId, String username) {
        for (Review r : reviews) {
            if (r.getMovieId().equals(movieId) && r.getUsername().equals(username)) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    @Override
    public Review save(Review review) {
        if (review.getId() == null) {
            // 새 리뷰
            review.setId(nextId++);
            reviews.add(review);
        } else {
            // 수정
            for (int i = 0; i < reviews.size(); i++) {
                if (reviews.get(i).getId().equals(review.getId())) {
                    reviews.set(i, review);
                    break;
                }
            }
        }
        return review;
    }

    @Override
    public void deleteById(Long id) {
        reviews.removeIf(r -> r.getId().equals(id));
    }
}