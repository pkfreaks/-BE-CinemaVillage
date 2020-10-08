package pl.edu.pk.freaks.cinemavillage.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "movie not found")
public class MovieNotFoundException extends RuntimeException {}
