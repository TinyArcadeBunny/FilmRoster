package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Film")

public class Film {

    @Id
    @Column(name = "FilmID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Film_Name")
    private String filmName;

    @Column(name = "Director_Name")
    private String directorName;

    @Column(name = "Runtime")
    private Time runtime;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Watched")
    private boolean watched;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String firstName) {
        this.filmName = firstName;
    }
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String lastName) {
        this.directorName = lastName;
    }
    public Time getRuntime() {
        return runtime;
    }
    public void setRuntime(Time runtime) {
        this.runtime = runtime;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
