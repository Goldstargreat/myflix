package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository
{
    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    List<Movie> findByGenre(String genre);
    Movie save(Movie movie);
    void deleteById(Long id);
}
