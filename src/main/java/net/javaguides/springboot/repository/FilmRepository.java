package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository <Film, Long >{
    @Query
    List<Film> findAllByWatchedIsFalse();
    @Query
    List<Film> findAllByWatchedIsTrue();
}
