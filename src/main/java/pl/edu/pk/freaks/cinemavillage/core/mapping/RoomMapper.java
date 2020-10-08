package pl.edu.pk.freaks.cinemavillage.core.mapping;

import pl.edu.pk.freaks.cinemavillage.core.entity.RoomEntity;
import pl.edu.pk.freaks.cinemavillage.core.model.RoomDto;

public class RoomMapper {

  public RoomDto toDto(RoomEntity entity) {
    return new RoomDto(entity.getId() != null ? entity.getId().toString() : null, entity.getName());
  }
}
