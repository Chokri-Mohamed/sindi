package tech.byrsa.sindibad.rest.handler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.byrsa.sindibad.rest.handler.model.ErrorMessage;
import tech.byrsa.sindibad.rest.handler.model.ErrorMessage.ExceptionKeysEnum;

@Component
public class ErrorMessageAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(final HttpServletRequest request, final HttpServletResponse response,
			final AccessDeniedException accessDeniedException) throws IOException, ServletException {
		final HttpStatus status = HttpStatus.FORBIDDEN;
		final ErrorMessage entityHandler = ErrorMessage.builder()
				.httpStatus(status)
				.message(status.getReasonPhrase())
				.key(ExceptionKeysEnum.ERROR_FORBIDDEN.getKey())
				.build();
		response.setStatus(status.value());
		final String entityHandlerString = convertObjectToJson(entityHandler);
		response.getWriter().write(entityHandlerString);
	}

	private String convertObjectToJson(final ErrorMessage object) throws JsonProcessingException {
		if (object == null) {
			return null;
		}
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
}