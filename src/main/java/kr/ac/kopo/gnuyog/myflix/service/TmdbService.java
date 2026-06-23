package kr.ac.kopo.gnuyog.myflix.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TmdbService
{
    @Value("${tmdb.api.key}")
    private String apiKey;

    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    public double fetchRating(String title)
    {
        // 1차: 영어로 검색
        double rating = fetchRatingByQuery(title);
        if (rating > 0.0) return rating;
        System.out.println("TMDB 평점 조회 실패: " + title);
        return 0.0;
    }

    private double fetchRatingByQuery(String query)
    {
        try {
            String encodedQuery = java.net.URLEncoder.encode(query, "UTF-8");
            String url = BASE_URL + "/search/movie?api_key=" + apiKey + "&query=" + encodedQuery + "&language=ko-KR";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();

            JsonNode root = objectMapper.readTree(body);
            JsonNode results = root.get("results");

            if (results != null && results.isArray() && results.size() > 0)
            {
                JsonNode first = results.get(0);
                double val = first.get("vote_average").asDouble();
                val = Math.round(val * 10.0) / 10.0;
                if (val > 0.0) return val;
            }
        } catch (Exception e) {
            System.out.println("TMDB HttpClient 오류: " + query + " → " + e.getMessage());
        }
        return 0.0;
    }

    public String fetchPosterUrl(String title)
    {
        try {
            String encodedQuery = java.net.URLEncoder.encode(title, "UTF-8");
            String url = BASE_URL + "/search/movie?api_key=" + apiKey + "&query=" + encodedQuery + "&language=ko-KR";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonNode root = objectMapper.readTree(response.body());
            JsonNode results = root.get("results");

            if (results != null && results.isArray() && results.size() > 0)
            {
                JsonNode first = results.get(0);
                JsonNode posterPath = first.get("poster_path");
                if (posterPath != null && !posterPath.isNull())
                {
                    return IMAGE_BASE_URL + posterPath.asText();
                }
            }
        } catch (Exception e)
        {
            System.out.println("TMDB 포스터 조회 실패: " + title + " → " + e.getMessage());
        }
        return null;
    }
}