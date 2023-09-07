package tech.byrsa.sindibad.database.converter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DurationConverter implements AttributeConverter<Duration, Long> {

    @Override
    public Long convertToDatabaseColumn(final Duration duration) {
        return duration.toSeconds();
    }

    @Override
    public Duration convertToEntityAttribute(final Long duration) {
        return Duration.of(duration, ChronoUnit.SECONDS);
    }
}