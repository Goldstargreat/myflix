package kr.ac.kopo.gnuyog.myflix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class TmdbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    // 영화 제목으로 TMDB 검색 → 평점 반환
    public double fetchRating(String title) {
        // 1차: 한국어로 검색
        double rating = fetchRatingByQuery(title, "ko-KR");
        if (rating > 0.0) return rating;

        // 2차: 영어로 재검색
        rating = fetchRatingByQuery(title, "en-US");
        if (rating > 0.0) return rating;

        System.out.println("TMDB 평점 조회 실패 (한/영 모두): " + title);
        return 0.0;
    }

    private double fetchRatingByQuery(String title, String language) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/search/movie")
                    .queryParam("api_key", apiKey)
                    .queryParam("query", title)
                    .queryParam("language", language)
                    .toUriString();

            Map result = restTemplate.getForObject(url, Map.class);
            if (result != null && result.get("results") != null) {
                java.util.List results = (java.util.List) result.get("results");
                if (!results.isEmpty()) {
                    Map movie = (Map) results.get(0);
                    Object ratingObj = movie.get("vote_average");
                    if (ratingObj instanceof Number) {
                        double val = Math.round(((Number) ratingObj).doubleValue() * 10.0) / 10.0;
                        if (val > 0.0) return val;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("TMDB 조회 예외 [" + language + "]: " + title + " → " + e.getMessage());
        }
        return 0.0;
    }

    // 영화 제목으로 TMDB 검색 → 포스터 URL 반환
    public String fetchPosterUrl(String title) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/search/movie")
                    .queryParam("api_key", apiKey)
                    .queryParam("query", title)
                    .queryParam("language", "ko-KR")
                    .toUriString();

            Map result = restTemplate.getForObject(url, Map.class);
            if (result != null && result.get("results") != null) {
                java.util.List results = (java.util.List) result.get("results");
                if (!results.isEmpty()) {
                    Map movie = (Map) results.get(0);
                    Object posterPath = movie.get("poster_path");
                    if (posterPath != null) {
                        return IMAGE_BASE_URL + posterPath;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("TMDB 포스터 조회 실패: " + title + " → " + e.getMessage());
        }
        return null;
    }
}