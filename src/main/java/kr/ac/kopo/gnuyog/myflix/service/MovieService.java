package kr.ac.kopo.gnuyog.myflix.service;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// 영화 관련 로직 처리 담당 클래스
@Service
public class MovieService
{
    @Autowired // Spring이 자동으로 MovieRepository 객체를 넣어줌
    private MovieRepository movieRepository;
    // DB 작업을 여기서 직접 하지 않고 Repository에 위임
    public List<Movie> getAllMovies()
    {  // 모든 영화 목록 가져오는 메서드
        return movieRepository.findAll(); // DB 또는 저장소에서 전체 데이터 조회
    }
    public Optional<Movie> getMovieById(Long id)
    {  // 영화 ID로 조회
        return movieRepository.findById(id);
    }
    public List<Movie> getMoviesByGenre(String genre)
    {
        return movieRepository.findByGenre(genre);
    }
    public Movie saveMovie(Movie movie)
    {   // 새 영화 저장 또는 수정
        return movieRepository.save(movie);
    }   // DB에 저장 요청
    public void deleteMovie(Long id)
    {   // 영화 삭제 기능
        movieRepository.deleteById(id);
    }  // ID 기준으로 삭제
}

// MovieRepository를 감싸서 컨트롤러에 서비스 형태로 제공하는 중간 계층

