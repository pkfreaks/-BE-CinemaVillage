package pl.edu.pk.freaks.cinemavillage.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "room not found")
public class RoomNotFoundException extends RuntimeException {}
