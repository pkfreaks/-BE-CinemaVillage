package pl.edu.pk.freaks.cinemavillage.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "genre")
  private String genre;

  @Column(name = "duration_in_seconds")
  private Long durationInSeconds;

  @Column(name = "description")
  private String description;

  @Column(name = "trailer_url")
  private String trailerUrl;

  @Column(name = "poster_url")
  private String posterUrl;

  public MovieEntity() {}

  public MovieEntity(
      Long id,
      String title,
      String genre,
      Long durationInSeconds,
      String description,
      String trailerUrl,
      String posterUrl) {
    this.id = id;
    this.title = title;
    this.genre = genre;
    this.durationInSeconds = durationInSeconds;
    this.description = description;
    this.trailerUrl = trailerUrl;
    this.posterUrl = posterUrl;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setDurationInSeconds(Long durationInSeconds) {
    this.durationInSeconds = durationInSeconds;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setTrailerUrl(String trailerUrl) {
    this.trailerUrl = trailerUrl;
  }

  public void setPosterUrl(String posterUrl) {
    this.posterUrl = posterUrl;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public Long getDurationInSeconds() {
    return durationInSeconds;
  }

  public String getDescription() {
    return description;
  }

  public String getTrailerUrl() {
    return trailerUrl;
  }

  public String getPosterUrl() {
    return posterUrl;
  }
}
