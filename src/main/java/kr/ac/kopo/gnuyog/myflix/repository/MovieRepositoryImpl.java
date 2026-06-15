package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // 이것은 DB 대신 데이터를 다루는 클래스이다
public class MovieRepositoryImpl implements MovieRepository
{  // MovieRepository 기능을 실제로 동작하게 만든 클래스
    private List<Movie> movies = new ArrayList<>();
    private Long nextId = 11L; // 새 영화 추가할 때 줄 번호(id) 기존 영화가 1~10이라서 다음은 11

    // 생성자 (처음 실행될 때 자동 실행)
    public MovieRepositoryImpl() {
        movies.add(new Movie(1L, "인터스텔라", "영화", "우주 탐험과 시간의 상대성을 다룬 SF 대작. 인류 생존을 위해 웜홀을 통과하는 우주비행사들의 이야기.", "https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=400&h=600&fit=crop", 2014, 8.6));
        movies.add(new Movie(2L, "라이언 일병 구하기", "영화", "2차 세계대전을 배경으로 한 명의 병사를 구하기 위해 목숨을 건 특수 임무를 그린 전쟁 영화.", "https://images.unsplash.com/photo-1580130775562-0ef92da028de?w=400&h=600&fit=crop", 1998, 8.6));
        movies.add(new Movie(3L, "어벤져스: 엔드게임", "영화", "마블 시네마틱 유니버스의 집대성. 타노스에 맞선 어벤져스의 마지막 전투.", "https://images.unsplash.com/photo-1612036782180-6f0b6cd846fe?w=400&h=600&fit=crop", 2019, 8.4));
        movies.add(new Movie(4L, "조커", "드라마", "아서 플렉이 조커가 되어가는 과정을 그린 심리 스릴러. 호아킨 피닉스의 열연.", "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=400&h=600&fit=crop", 2019, 8.4));
        movies.add(new Movie(5L, "듄", "영화", "모래 행성 아라키스를 배경으로 한 폴 아트레이데스의 운명을 그린 SF 서사시.", "https://images.unsplash.com/photo-1509347528160-9a9e33742cdb?w=400&h=600&fit=crop", 2021, 8.0));
        movies.add(new Movie(6L, "탑건: 매버릭", "영화", "30년 만에 돌아온 매버릭의 전설. 탐 크루즈의 실제 전투기 비행 장면이 압권.", "https://images.unsplash.com/photo-1540979388789-6cee28a1cdc9?w=400&h=600&fit=crop", 2022, 8.3));
        movies.add(new Movie(7L, "아버지의 깃발", "드라마", "이오지마 전투에서 성조기를 꽂은 병사들의 이야기를 미국 시각에서 그린 클린트 이스트우드의 전쟁 드라마.", "https://images.unsplash.com/photo-1569982175971-d92b01cf8694?w=400&h=600&fit=crop", 2006, 7.0));
        movies.add(new Movie(8L, "겨울왕국", "애니메이션", "얼음 마법을 가진 엘사와 동생 안나의 자매 사랑을 그린 디즈니 애니메이션.", "https://images.unsplash.com/photo-1547036967-23d11aacaee0?w=400&h=600&fit=crop", 2013, 7.4));
        movies.add(new Movie(9L, "오펜하이머", "드라마", "원자폭탄의 아버지 오펜하이머의 삶과 그 무게를 담은 크리스토퍼 놀란의 역작.", "https://images.unsplash.com/photo-1522202176988-66273c2fd55f?w=400&h=600&fit=crop", 2023, 8.5));
        movies.add(new Movie(10L, "스파이더맨: 노 웨이 홈", "영화", "멀티버스가 열리며 역대 스파이더맨들이 한자리에 모이는 마블의 역작.", "https://images.unsplash.com/photo-1635805737707-575885ab0820?w=400&h=600&fit=crop", 2021, 8.2));
    }

    // 전체 영화 조회
    @Override
    public List<Movie> findAll()
    {
        return new ArrayList<Movie>(movies); // 영화 전체 목록을 복사해서 반환
    }

    // ID로 영화 찾기
    @Override
    public Optional<Movie> findById(Long id)
    {
        for (Movie m : movies) // movies 리스트를 하나씩 돌면서 검사
        {
            if (m.getId().equals(id))
            {
                return Optional.of(m); // id가 같으면 찾은 거니까 반환
            }
        }
        return Optional.empty(); // 끝까지 못 찾으면 “없다” 반환
    }

     // 장르로 찾기
    @Override
    public List<Movie> findByGenre(String genre)
    {
        List<Movie> result = new ArrayList<Movie>(); // 결과를 담을 비어있는 리스트
        for (Movie m : movies) // “movies 리스트 안에 있는 Movie를 하나씩 꺼내서 m에 넣으면서 반복해라”
        {
            if (m.getGenre().equals(genre))
            {
                result.add(m);
            }
        }
        return result;
    }

    // 영화 저장 (추가 + 수정)
    @Override
    public Movie save(Movie movie)
    {
        if (movie.getId() == null) // id 없으면 “새 영화”
        {
            movie.setId(nextId++); // 새 번호 부여 (11, 12, 13...)
            movies.add(movie); // 리스트에 추가
        } else // id 있으면 “수정”
        {
            for (int i = 0; i < movies.size(); i++)
            {
                if (movies.get(i).getId().equals(movie.getId()))
                {
                    movies.remove(i); // 기존 데이터 삭제 후 종료
                    break;
                }
            }
            movies.add(movie);
        }
        return movie;
    }

    // 삭제 기능
    @Override
    public void deleteById(Long id)
    {
        for (int i = 0; i < movies.size(); i++)
        {
            if (movies.get(i).getId().equals(id))
            {
                movies.remove(i);
                break;
            }
        }
    }
}