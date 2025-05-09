package com.real.interview.converter;

import com.real.interview.dto.MovieDto;
import com.real.interview.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieDtoConverter implements Converter<MovieDto, Movie> {
    @Override
    public Movie convert(MovieDto source) {
        return new Movie(source.getTitle(), source.getReleaseYear());
    }
}
