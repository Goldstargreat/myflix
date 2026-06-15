package kr.ac.kopo.gnuyog.myflix.model;

public class Movie
{
    private Long id;
    private String title;
    private String genre;
    private String description;
    private String thumbnailUrl; // 영화 포스터 이미지 주소(URL)
    private int releaseYear; // 출시 연도
    private double rating; // 평점

    public Movie()
    {
        // 기본 생성자 비어있는 Movie 객체를 만들 수 있게 해주는 생성자
    }

    // 전체 데이터를 한 번에 넣는 생성자
    public Movie(Long id, String title, String genre, String description,
                 String thumbnailUrl, int releaseYear, double rating)
    {
        this.id = id;  // 좌측은 객체 안의 변수, 우측은 입력값
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
    // Getter (값 꺼내기)
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title; // 제목을 가져와서 title 값을 밖으로 돌려줌
    }

    // Setter (값 바꾸기)
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getGenre()
    {
        return genre;
    }
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getThumbnailUrl()
    {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }
    public int getReleaseYear()
    {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }
    public double getRating()
    {
        return rating;
    }
    public void setRating(double rating)
    {
        this.rating = rating;
    }
}
