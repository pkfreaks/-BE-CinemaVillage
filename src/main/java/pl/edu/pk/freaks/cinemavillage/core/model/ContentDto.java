package pl.edu.pk.freaks.cinemavillage.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ContentDto<T> {

  private final List<T> content;

  @JsonCreator
  public ContentDto(@JsonProperty("content") List<T> content) {
    this.content = content;
  }

  @JsonProperty("content")
  public List<T> getContent() {
    return content;
  }
}
