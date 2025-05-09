package com.real.interview.service;

import com.real.interview.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> findByTitle(String title);

    List<MovieDto> findByReleaseYear(Integer releaseYear);

    MovieDto save(MovieDto movie);

    MovieDto update(MovieDto movieDto);

    void delete(Long id);
}
