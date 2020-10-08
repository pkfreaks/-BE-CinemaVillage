package pl.edu.pk.freaks.cinemavillage.core;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pk.freaks.cinemavillage.core.entity.RoomEntity;
import pl.edu.pk.freaks.cinemavillage.core.entity.RoomRepository;
import pl.edu.pk.freaks.cinemavillage.core.exception.RoomNotFoundException;
import pl.edu.pk.freaks.cinemavillage.core.mapping.RoomMapper;
import pl.edu.pk.freaks.cinemavillage.core.model.ContentDto;
import pl.edu.pk.freaks.cinemavillage.core.model.RoomDto;

@Service
public class RoomService {

  private final RoomRepository roomRepository;

  private final RoomMapper roomMapper = new RoomMapper();

  public RoomService(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public ContentDto<RoomDto> getAllRooms() {
    List<RoomEntity> entities = roomRepository.findAll();
    List<RoomDto> dtos = entities.stream().map(roomMapper::toDto).collect(Collectors.toList());
    return new ContentDto<>(dtos);
  }

  public RoomDto getRoom(String id) {
    RoomEntity entity = fetch(id);
    return roomMapper.toDto(entity);
  }

  private RoomEntity fetch(String id) {
    try {
      Long idAsLong = Long.parseLong(id);
      return roomRepository.findById(idAsLong).orElseThrow(RoomNotFoundException::new);
    } catch (NumberFormatException e) {
      throw new RoomNotFoundException();
    }
  }

  public RoomDto createRoom(RoomDto room) {
    RoomEntity entity = new RoomEntity(null, room.getName());
    entity = roomRepository.save(entity);
    return roomMapper.toDto(entity);
  }

  @Transactional
  public RoomDto updateRoom(String id, RoomDto room) {
    RoomEntity entity = fetch(id);
    entity.setName(room.getName());
    return roomMapper.toDto(entity);
  }

  public void deleteRoom(String id) {
    try {
      roomRepository.deleteById(Long.valueOf(id));
    } catch (NumberFormatException e) {
      // It doesn't matter
    }
  }
}
