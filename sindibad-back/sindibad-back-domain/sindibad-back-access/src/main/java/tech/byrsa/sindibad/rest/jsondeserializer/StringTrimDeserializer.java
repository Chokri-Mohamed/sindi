package tech.byrsa.sindibad.rest.jsondeserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StringTrimDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(final JsonParser parser, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final String text = parser.getText(); 
        String deserializedText = null;
        if(text != null) {
            deserializedText = text.trim();
        }
        return deserializedText; 
    }
}