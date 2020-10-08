package pl.edu.pk.freaks.cinemavillage.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {

  private final String id;
  private final String title;
  private final String genre;
  private final Long durationInSeconds;
  private final String description;
  private final String trailerUrl;
  private final String posterUrl;

  @JsonCreator
  public MovieDto(
      @JsonProperty("id") String id,
      @JsonProperty("title") String title,
      @JsonProperty("genre") String genre,
      @JsonProperty("durationInSeconds") Long durationInSeconds,
      @JsonProperty("description") String description,
      @JsonProperty("trailerUrl") String trailerUrl,
      @JsonProperty("posterUrl") String posterUrl) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.durationInSeconds = durationInSeconds;
    this.description = description;
    this.trailerUrl = trailerUrl;
    this.posterUrl = posterUrl;
  }

  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("genre")
  public String getGenre() {
    return genre;
  }

  @JsonProperty("durationInSeconds")
  public Long getDurationInSeconds() {
    return durationInSeconds;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("trailerUrl")
  public String getTrailerUrl() {
    return trailerUrl;
  }

  @JsonProperty("posterUrl")
  public String getPosterUrl() {
    return posterUrl;
  }
}
