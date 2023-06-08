package tech.byrsa.sindibad.configuration;

import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.context.annotation.Bean;

public class JacksonConfiguration {

	@Bean
    public JsonNullableModule jsonNullableModule() {
        return new JsonNullableModule();
    }
}
