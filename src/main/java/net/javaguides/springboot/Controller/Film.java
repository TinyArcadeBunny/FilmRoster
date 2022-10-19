package net.javaguides.springboot.Controller;

import javax.persistence.*;

@Entity
@Table(name = "Film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "film_name")
    private String filmname;

    @Column(name = "director_name")
    private String directorname;
    @Column(name = "runtime")
    private String runtime;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFilmname() {
        return filmname;
    }
    public void setFilmname(String firstName) {
        this.filmname = firstName;
    }
    public String getDirectorname() {
        return directorname;
    }
    public void setDirectorname(String lastName) {
        this.directorname = lastName;
    }
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String email) {
        this.runtime = email;
    }
}
