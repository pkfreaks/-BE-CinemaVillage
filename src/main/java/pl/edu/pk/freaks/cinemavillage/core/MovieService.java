package pl.edu.pk.freaks.cinemavillage.core;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pk.freaks.cinemavillage.core.entity.MovieEntity;
import pl.edu.pk.freaks.cinemavillage.core.entity.MovieRepository;
import pl.edu.pk.freaks.cinemavillage.core.exception.MovieNotFoundException;
import pl.edu.pk.freaks.cinemavillage.core.mapping.MovieMapper;
import pl.edu.pk.freaks.cinemavillage.core.model.ContentDto;
import pl.edu.pk.freaks.cinemavillage.core.model.MovieDto;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  private final MovieMapper movieMapper = new MovieMapper();

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public ContentDto<MovieDto> getAllMovies() {
    List<MovieEntity> entities = movieRepository.findAll();
    List<MovieDto> dtos = entities.stream().map(movieMapper::toDto).collect(Collectors.toList());
    return new ContentDto<>(dtos);
  }

  public MovieDto getMovie(String id) {
    MovieEntity entity = fetch(id);
    return movieMapper.toDto(entity);
  }

  private MovieEntity fetch(String id) {
    try {
      Long idAsLong = Long.parseLong(id);
      return movieRepository.findById(idAsLong).orElseThrow(MovieNotFoundException::new);
    } catch (NumberFormatException e) {
      throw new MovieNotFoundException();
    }
  }

  public MovieDto createMovie(MovieDto movie) {
    MovieEntity entity =
        new MovieEntity(
            null,
            movie.getTitle(),
            movie.getGenre(),
            movie.getDurationInSeconds(),
            movie.getDescription(),
            movie.getTrailerUrl(),
            movie.getPosterUrl());
    entity = movieRepository.save(entity);
    return movieMapper.toDto(entity);
  }

  @Transactional
  public MovieDto updateMovie(String id, MovieDto movie) {
    MovieEntity entity = fetch(id);
    entity.setTitle(movie.getTitle());
    entity.setGenre(movie.getGenre());
    entity.setDurationInSeconds(movie.getDurationInSeconds());
    entity.setDescription(movie.getDescription());
    entity.setTrailerUrl(movie.getTrailerUrl());
    entity.setPosterUrl(movie.getPosterUrl());
    return movieMapper.toDto(entity);
  }

  public void deleteMovie(String id) {
    try {
      movieRepository.deleteById(Long.valueOf(id));
    } catch (NumberFormatException e) {
      // It doesn't matter
    }
  }
}
