package net.javaguides.springboot.Service;

import net.javaguides.springboot.model.Film;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FilmService {
    List<Film> getALLFilms();
    void saveFilm(Film film);
    Film getFilmById(long id);
    void deleteFilmById(long id);
    Page<Film> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}

