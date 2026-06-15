package kr.ac.kopo.gnuyog.myflix.service;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService
{
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }
    public Optional<Movie> getMovieById(Long id)
    {
        return movieRepository.findById(id);
    }
    public List<Movie> getMoviesByGenre(String genre)
    {
        return movieRepository.findByGenre(genre);
    }
    public Movie saveMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }
    public void deleteMovie(Long id)
    {
        movieRepository.deleteById(id);
    }
}

