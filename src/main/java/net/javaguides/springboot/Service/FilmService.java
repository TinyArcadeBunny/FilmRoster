package net.javaguides.springboot.Service;

import net.javaguides.springboot.Controller.Film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FilmService {
    List<Film> getALLEmployees();
    void saveFilm(Film film);
    Film getFilmById(long id);
    void deleteFilmById(long id);
    Page<Film> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    Object getAllFilms();
}

