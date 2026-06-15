package kr.ac.kopo.gnuyog.myflix.model;

public class Movie
{
    private Long id;
    private String title;
    private String genre;
    private String description;
    private String thumbnailUrl;
    private int releaseYear;
    private double rating;

    public Movie(){}

    public Movie(Long id, String title, String genre, String description,
                 String thumbnailUrl, int releaseYear, double rating){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }
    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
}
