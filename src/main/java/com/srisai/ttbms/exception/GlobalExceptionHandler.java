package com.srisai.ttbms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> badRequest(IllegalArgumentException e) {
		return Map.of("error", e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> invalid(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getFieldErrors().stream().findFirst()
				.map(x -> x.getField() + ": " + x.getDefaultMessage()).orElse("Invalid request");
		return Map.of("error", message);
	}
}
