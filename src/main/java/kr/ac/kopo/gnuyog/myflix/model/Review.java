package kr.ac.kopo.gnuyog.myflix.model;

public class Review {
    private Long id;
    private Long movieId;
    private String username;
    private double myRating;   // 사용자 별점 (1.0 ~ 10.0)
    private String comment;    // 150자 평

    public Review() {}

    public Review(Long id, Long movieId, String username, double myRating, String comment) {
        this.id = id;
        this.movieId = movieId;
        this.username = username;
        this.myRating = myRating;
        this.comment = comment;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public double getMyRating() { return myRating; }
    public void setMyRating(double myRating) { this.myRating = myRating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}