package com.real.interview.service;

import com.real.interview.converter.MovieConverter;
import com.real.interview.converter.MovieDtoConverter;
import com.real.interview.dto.MovieDto;
import com.real.interview.entity.Movie;
import com.real.interview.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MovieService {
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final MovieConverter movieConverter;
    @Autowired
    private final MovieDtoConverter movieDtoConverter;

    @Override
    public List<MovieDto> findByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        return movies.stream().map(movieConverter::convert).toList();
    }

    @Override
    public List<MovieDto> findByReleaseYear(Integer releaseYear) {
        List<Movie> movies = movieRepository.findByReleaseYear(releaseYear);
        return movies.stream().map(movieConverter::convert).toList();
    }

    @Override
    public MovieDto save(MovieDto movie) {
        final Movie movieEntity = movieDtoConverter.convert(movie);
        final Movie savedEntity = movieRepository.save(movieEntity);
        return movieConverter.convert(savedEntity);
    }

    @Override
    public MovieDto update(MovieDto movieDto) {
        final Optional<Movie> movie = movieRepository.findById(movieDto.getId());
        if (!movie.isPresent()) {
            throw new RuntimeException("not found");
        }
        Movie updateMovie = new Movie(movieDto.getId(), movieDto.getTitle(), movieDto.getReleaseYear());
        return movieConverter.convert(movieRepository.save(updateMovie));
    }

    @Override
    public void delete(Long id) {
        final Optional<Movie> movie = movieRepository.findById(id);
        if (!movie.isPresent()) {
            throw new RuntimeException("not found");
        }
        movieRepository.delete(movie.get());
    }


}
