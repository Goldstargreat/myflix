package kr.ac.kopo.gnuyog.myflix.repository;
// DB 접근 담당 폴더

import kr.ac.kopo.gnuyog.myflix.model.Movie;

import java.util.List;
import java.util.Optional; // 영화가 존재할 수 도 있고 없을 수도 있다.

public interface MovieRepository
{
    // 영화를 다루는 기능 목록만 정의한 설계도
    List<Movie> findAll(); // 영화 전체 목록 가져오기
    Optional<Movie> findById(Long id); // 특정 영화 1개 찾기
    List<Movie> findByGenre(String genre); // 특정 장르 영화 가져오기
    Movie save(Movie movie); // 새 영화 추가, 기존 영화 수정도 가능
    void deleteById(Long id); // ID로 영화 삭제
}
