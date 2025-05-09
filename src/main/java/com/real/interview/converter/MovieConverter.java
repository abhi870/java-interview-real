package com.real.interview.converter;

import com.real.interview.dto.MovieDto;
import com.real.interview.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieConverter implements Converter<Movie, MovieDto> {

    @Override
    public MovieDto convert(Movie source) {
        return new MovieDto(source.getId(), source.getTitle(), source.getReleaseYear());
    }
}
