package com.real.interview.repository;

import com.real.interview.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findByTitle(String title);

    List<Movie> findByReleaseYear(Integer releaseYear);


}
