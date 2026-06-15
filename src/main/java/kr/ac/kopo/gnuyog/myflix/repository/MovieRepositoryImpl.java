package kr.ac.kopo.gnuyog.myflix.repository;

import kr.ac.kopo.gnuyog.myflix.model.Movie;
import kr.ac.kopo.gnuyog.myflix.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository
{
    @Autowired
    private TmdbService tmdbService;

    private List<Movie> movies = new ArrayList<>();
    private Long nextId = 31L;

    // 앱 시작 시 TMDB에서 평점/포스터 자동 갱신
    @PostConstruct
    public void init()
    {
        // ─── 영화 ───────────────────────────────────────────────
        movies.add(new Movie(1L,  "인터스텔라",            "영화",      "우주 탐험과 시간의 상대성을 다룬 SF 대작. 인류 생존을 위해 웜홀을 통과하는 우주비행사들의 이야기.",           "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg", 2014, 0.0));
        movies.add(new Movie(2L,  "라이언 일병 구하기",    "영화",      "2차 세계대전을 배경으로 한 명의 병사를 구하기 위해 목숨을 건 특수 임무를 그린 전쟁 영화.",               "https://image.tmdb.org/t/p/w500/uqx37cS8cpHg8U35f9U5IBlrCV3.jpg", 1998, 0.0));
        movies.add(new Movie(3L,  "어벤져스: 엔드게임",    "영화",      "마블 시네마틱 유니버스의 집대성. 타노스에 맞선 어벤져스의 마지막 전투.",                                  "https://image.tmdb.org/t/p/w500/or06FN3Dka5tukK1e9sl16pB3iy.jpg", 2019, 0.0));
        movies.add(new Movie(5L,  "듄",                    "영화",      "모래 행성 아라키스를 배경으로 한 폴 아트레이데스의 운명을 그린 SF 서사시.",                                "https://image.tmdb.org/t/p/w500/d5NXSklpcvweCLoy3Hpz0K3c4p9.jpg", 2021, 0.0));
        movies.add(new Movie(6L,  "탑건: 매버릭",          "영화",      "30년 만에 돌아온 매버릭의 전설. 톰 크루즈의 실제 전투기 비행 장면이 압권.",                               "https://image.tmdb.org/t/p/w500/62HCnUTziyWcpDaBO2i1DX17ljH.jpg", 2022, 0.0));
        movies.add(new Movie(10L, "스파이더맨: 노 웨이 홈","영화",      "멀티버스가 열리며 역대 스파이더맨들이 한자리에 모이는 마블의 역작.",                                      "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg", 2021, 0.0));
        movies.add(new Movie(11L, "다크 나이트",            "영화",      "배트맨과 조커의 숨막히는 대결. 히어로 영화의 새 기준을 세운 크리스토퍼 놀란의 걸작.",                     "https://image.tmdb.org/t/p/w500/qJ2tW6WMUDux911r6m7haRef0WH.jpg", 2008, 0.0));
        movies.add(new Movie(12L, "매트릭스",               "영화",      "가상 현실과 인류의 자유를 둘러싼 철학적 SF 액션.",                                                        "https://image.tmdb.org/t/p/w500/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg", 1999, 0.0));
        movies.add(new Movie(13L, "기생충",                 "영화",      "빈부격차를 날카롭게 풍자한 봉준호 감독의 역작. 칸 황금종려상·아카데미 작품상 수상.",                      "https://image.tmdb.org/t/p/w500/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg", 2019, 0.0));
        movies.add(new Movie(14L, "범죄도시",               "영화",      "괴물 형사 마석도와 흉악 범죄 조직의 통쾌한 대결을 그린 한국 액션 블록버스터.",                           "https://image.tmdb.org/t/p/w500/cR4F3bH0YVNHZSBQ5DJPXgGBgrz.jpg", 2017, 0.0));

        // ─── 드라마 ─────────────────────────────────────────────
        movies.add(new Movie(4L,  "조커",                   "드라마",    "아서 플렉이 조커가 되어가는 과정을 그린 심리 스릴러. 호아킨 피닉스의 열연.",                               "https://image.tmdb.org/t/p/w500/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg", 2019, 0.0));
        movies.add(new Movie(7L,  "아버지의 깃발",           "드라마",    "이오지마 전투에서 성조기를 꽂은 병사들의 이야기를 미국 시각에서 그린 클린트 이스트우드의 전쟁 드라마.",   "https://image.tmdb.org/t/p/w500/bDFMFMKFUMJtSHHNMYlBBNFDQoA.jpg", 2006, 0.0));
        movies.add(new Movie(9L,  "오펜하이머",              "드라마",    "원자폭탄의 아버지 오펜하이머의 삶과 그 무게를 담은 크리스토퍼 놀란의 역작.",                             "https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg", 2023, 0.0));
        movies.add(new Movie(15L, "쇼생크 탈출",             "드라마",    "억울하게 수감된 앤디 듀프레인의 희망과 탈출을 그린 불후의 명작.",                                         "https://image.tmdb.org/t/p/w500/lyQBXzOQSuE59IsHyhrp0qIiPAz.jpg", 1994, 0.0));
        movies.add(new Movie(16L, "포레스트 검프",            "드라마",    "평범하지 않은 삶을 살아온 포레스트 검프의 일생을 통해 미국 현대사를 돌아보는 감동 드라마.",              "https://image.tmdb.org/t/p/w500/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg", 1994, 0.0));
        movies.add(new Movie(17L, "1917",                    "드라마",    "1차 세계대전, 단 두 명의 병사가 수천 명을 구하기 위해 적진을 가로질러 달리는 원테이크 전쟁 드라마.",     "https://image.tmdb.org/t/p/w500/iZf0KyrE25z1sage4SYFLCCrMi9.jpg", 2019, 0.0));

        // ─── 애니메이션 ──────────────────────────────────────────
        movies.add(new Movie(8L,  "겨울왕국",               "애니메이션","얼음 마법을 가진 엘사와 동생 안나의 자매 사랑을 그린 디즈니 애니메이션.",                                "https://image.tmdb.org/t/p/w500/iG1pHfJzNHeIFcHMaL5Os1K8Oq2.jpg", 2013, 0.0));
        movies.add(new Movie(18L, "센과 치히로의 행방불명",  "애니메이션","평범한 소녀 치히로가 신들의 세계에서 살아남기 위해 분투하는 미야자키 하야오의 걸작.",                    "https://image.tmdb.org/t/p/w500/39wmItIWsg5sZMyRUHLkWBcuVCM.jpg", 2001, 0.0));
        movies.add(new Movie(19L, "너의 이름은",             "애니메이션","도쿄 소년과 시골 소녀가 꿈속에서 몸이 바뀌는 신비로운 경험을 하는 신카이 마코토의 애니메이션.",           "https://image.tmdb.org/t/p/w500/q719jXXEzOoYaps6babgKnONONX.jpg", 2016, 0.0));
        movies.add(new Movie(20L, "라이온 킹",               "애니메이션","아버지를 잃고 왕좌를 되찾는 심바의 여정을 그린 디즈니 불멸의 클래식.",                                  "https://image.tmdb.org/t/p/w500/sKCr78MXSLixwmZ8DyJLrpMsd15.jpg", 1994, 0.0));
        movies.add(new Movie(21L, "스즈메의 문단속",         "애니메이션","일본 전역의 문을 닫으러 여행을 떠나는 소녀 스즈메의 이야기.",                                            "https://image.tmdb.org/t/p/w500/jSrBPOBU7dOEiJcQfZ3dNFpJmQk.jpg", 2022, 0.0));

        // ─── 다큐멘터리 ──────────────────────────────────────────
        movies.add(new Movie(22L, "펭귄: 위대한 본능",       "다큐멘터리","남극 혹한 속에서 새끼를 지키는 황제펭귄 아버지들의 감동적인 여정.",                                      "https://image.tmdb.org/t/p/w500/8dHsvdiZMoZS9RrFrHBDUgQFPMj.jpg", 2005, 0.0));
        movies.add(new Movie(23L, "프리 솔로",               "다큐멘터리","알렉스 호놀드가 로프 없이 엘 카피탄을 단독 등반하는 인류 역사상 가장 위험한 도전.",                    "https://image.tmdb.org/t/p/w500/rOmUuQEiHgFMNnFqFhMkHMPFqOA.jpg", 2018, 0.0));
        movies.add(new Movie(24L, "더 소셜 딜레마",          "다큐멘터리","소셜 미디어가 어떻게 인간의 심리를 조작하고 사회를 분열시키는지 내부자들이 고발하는 넷플릭스 다큐.",     "https://image.tmdb.org/t/p/w500/2q6RtFRMrlP4iEBUKH0Wsl6c3e0.jpg", 2020, 0.0));
        movies.add(new Movie(25L, "불편한 진실",              "다큐멘터리","지구 온난화와 기후 위기의 실태를 앨 고어가 직접 고발하는 환경 다큐멘터리.",                             "https://image.tmdb.org/t/p/w500/oE6bhqqVFuYDd7LBBqMOtXbFMKz.jpg", 2006, 0.0));

        // ─── 뮤지컬 ─────────────────────────────────────────────
        movies.add(new Movie(26L, "라라랜드",                "뮤지컬",   "꿈을 좇는 재즈 피아니스트와 배우 지망생의 달콤 쌉싸름한 사랑을 그린 현대 뮤지컬 영화.",               "https://image.tmdb.org/t/p/w500/uDO8zWDhfWwoFdKS4fzkUJt0Rf0.jpg", 2016, 0.0));
        movies.add(new Movie(27L, "보헤미안 랩소디",          "뮤지컬",   "전설의 록밴드 퀸과 프레디 머큐리의 삶을 그린 전기 뮤지컬 영화.",                                       "https://image.tmdb.org/t/p/w500/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg", 2018, 0.0));
        movies.add(new Movie(28L, "사운드 오브 뮤직",         "뮤지컬",   "수련 수녀 마리아가 폰 트랩 대령 가족의 가정교사가 되어 음악으로 사랑을 키워가는 뮤지컬 고전.",         "https://image.tmdb.org/t/p/w500/dMRyGbFAiNNnTxbHxWwF02GN8rD.jpg", 1965, 0.0));
        movies.add(new Movie(29L, "레미제라블",               "뮤지컬",   "빅토르 위고의 원작을 바탕으로 혁명과 사랑, 구원을 노래하는 대서사 뮤지컬.",                             "https://image.tmdb.org/t/p/w500/8NiRHGBgLSHhJQQBDC1MPAH3GrA.jpg", 2012, 0.0));
        movies.add(new Movie(30L, "맘마미아",                 "뮤지컬",   "ABBA의 명곡들로 가득 찬 결혼식 전날 밤, 아버지를 찾아 나선 소녀의 유쾌한 이야기.",                    "https://image.tmdb.org/t/p/w500/3O1EPe9MPCG2vQGqr6BKVZvNwRZ.jpg", 2008, 0.0));

        // TMDB에서 평점 자동 갱신
        for (Movie movie : movies)
        {
            double rating = tmdbService.fetchRating(movie.getTitle());
            if (rating > 0.0)
            {
                movie.setRating(rating);
            }
        }
    }

    @Override
    public List<Movie> findAll()
    {
        return new ArrayList<>(movies);
    }

    @Override
    public Optional<Movie> findById(Long id)
    {
        for (Movie m : movies)
        {
            if (m.getId().equals(id))
            {
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Movie> findByGenre(String genre)
    {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movies)
        {
            if (m.getGenre().equals(genre))
            {
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Movie save(Movie movie)
    {
        if (movie.getId() == null)
        {
            movie.setId(nextId++);
            movies.add(movie);
        } else
        {
            for (int i = 0; i < movies.size(); i++)
            {
                if (movies.get(i).getId().equals(movie.getId()))
                {
                    movies.remove(i);
                    break;
                }
            }
            movies.add(movie);
        }
        return movie;
    }

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