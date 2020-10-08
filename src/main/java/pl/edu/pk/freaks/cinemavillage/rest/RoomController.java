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
import pl.edu.pk.freaks.cinemavillage.core.RoomService;
import pl.edu.pk.freaks.cinemavillage.core.model.ContentDto;
import pl.edu.pk.freaks.cinemavillage.core.model.RoomDto;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public ContentDto<RoomDto> getAllRooms() {
    return roomService.getAllRooms();
  }

  @GetMapping(path = "/{id}")
  public RoomDto getRoom(@PathVariable("id") String id) {
    return roomService.getRoom(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RoomDto createRoom(@RequestBody RoomDto requestBody) {
    return roomService.createRoom(requestBody);
  }

  @PutMapping(path = "/{id}")
  public RoomDto updateRoom(@PathVariable("id") String id, @RequestBody RoomDto requestBody) {
    return roomService.updateRoom(id, requestBody);
  }

  @DeleteMapping(path = "/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteRoom(@PathVariable("id") String id) {
    roomService.deleteRoom(id);
  }
}
