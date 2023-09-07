package tech.byrsa.sindibad.rest.handler;

import java.time.Clock;
import java.time.Instant;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tech.byrsa.sindibad.rest.handler.model.ErrorMessage;
import tech.byrsa.sindibad.rest.handler.model.ErrorMessage.ExceptionKeysEnum;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {

	private final Clock clock;

	@ExceptionHandler(ObjectOptimisticLockingFailureException.class)
	public ResponseEntity<Void> handleObjectOptimisticLockingFailure(final ObjectOptimisticLockingFailureException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Void> handleNoSuchElement(final NoSuchElementException ex) {
		log.error(ex.getMessage(), ex);
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleServerErrorException(final Exception e) {
		log.error(e.getMessage(), e);
		final HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
		final ErrorMessage entityHandler = ErrorMessage.builder()
				.message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
				.httpStatus(serverError)
				.timestamp(Instant.now(clock))
				.key(ExceptionKeysEnum.ERROR_SERVER.getKey())
				.build();
		return ResponseEntity.status(serverError).body(entityHandler);

	}
}
