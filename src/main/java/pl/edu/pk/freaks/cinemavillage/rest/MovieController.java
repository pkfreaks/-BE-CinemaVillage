package pl.edu.pk.freaks.cinemavillage.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pk.freaks.cinemavillage.core.MovieService;
import pl.edu.pk.freaks.cinemavillage.core.model.ContentDto;
import pl.edu.pk.freaks.cinemavillage.core.model.MovieDto;

@RestController
@RequestMapping(path = "/api/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ContentDto<MovieDto> getAllMovies() {
    return movieService.getAllMovies();
  }

  @GetMapping(path = "/{id}")
  public MovieDto getMovie(@PathVariable("id") String id) {
    return movieService.getMovie(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MovieDto createMovie(@RequestBody MovieDto requestBody) {
    return movieService.createMovie(requestBody);
  }

  @PutMapping(path = "/{id}")
  public MovieDto updateMovie(@PathVariable("id") String id, @RequestBody MovieDto requestBody) {
    return movieService.updateMovie(id, requestBody);
  }

  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteMovie(@PathVariable("id") String id) {
    movieService.deleteMovie(id);
  }
}
