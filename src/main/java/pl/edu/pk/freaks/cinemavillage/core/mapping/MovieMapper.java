package pl.edu.pk.freaks.cinemavillage.core.mapping;

import pl.edu.pk.freaks.cinemavillage.core.entity.MovieEntity;
import pl.edu.pk.freaks.cinemavillage.core.model.MovieDto;

public class MovieMapper {

  public MovieDto toDto(MovieEntity entity) {
    return new MovieDto(
        entity.getId() != null ? entity.getId().toString() : null,
        entity.getTitle(),
        entity.getGenre(),
        entity.getDurationInSeconds(),
        entity.getDescription(),
        entity.getTrailerUrl(),
        entity.getPosterUrl());
  }
}
