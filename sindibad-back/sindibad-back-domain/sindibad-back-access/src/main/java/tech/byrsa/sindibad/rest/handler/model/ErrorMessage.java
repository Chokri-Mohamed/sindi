package tech.byrsa.sindibad.rest.handler.model;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
	private String message;
	private HttpStatus httpStatus;
	private Instant timestamp;
	private String key;

	@Getter
	@AllArgsConstructor
	public enum ExceptionKeysEnum {
		ERROR_SERVER("server.error"),
		ERROR_FORBIDDEN("error.forbidden");

		private final String key;

	}
}
