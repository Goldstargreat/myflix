package kr.ac.kopo.gnuyog.myflix.model;

import java.util.ArrayList;
import java.util.List;

public class WishList
{
    private String username;
    private List<Long> movieIds = new ArrayList<>();

    public WishList()
    {

    }
    public WishList(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public List<Long> getMovieIds()
    {
        return movieIds;
    }
    public void setMovieIds(List<Long> movieIds)
    {
        this.movieIds = movieIds;
    }
    public void addMovie(Long movieId)
    {
        if (!movieIds.contains(movieId)) movieIds.add(movieId);
    }
    public void removeMovie(Long movieId)
    {
        movieIds.remove(movieId);
    }

    public boolean contains(Long movieId)
    {
        return movieIds.contains(movieId);
    }
}