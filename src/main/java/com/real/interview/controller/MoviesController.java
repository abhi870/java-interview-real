package com.real.interview.controller;

import com.real.interview.dto.MovieDto;
import com.real.interview.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private final MovieService movieService;

    @GetMapping("/title")
    public List<MovieDto> findMoviesByTitle(@RequestParam(value = "title") String title) {
        return movieService.findByTitle(title);
    }

    @GetMapping("/year")
    List<MovieDto> findMoviesByReleaseYear(@RequestParam(value = "releaseYear") Integer releaseYear) {
        return movieService.findByReleaseYear(releaseYear);
    }

    @PutMapping
    MovieDto updateMovie(@RequestBody MovieDto movieDto) {
        return movieService.update(movieDto);
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable(value = "id") Long id) {
        movieService.delete(id);
    }

    @PostMapping
    MovieDto saveMovie(@RequestBody MovieDto movieDto) {
        return movieService.save(movieDto);
    }
}
