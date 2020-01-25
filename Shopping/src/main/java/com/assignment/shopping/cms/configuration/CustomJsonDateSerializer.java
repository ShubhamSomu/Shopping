package com.assignment.shopping.cms.configuration;

import java.io.IOException;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomJsonDateSerializer extends JsonSerializer<LocalDateTime> {

    private static DateTimeFormatter formatter = 
        DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, 
                          SerializerProvider arg2)
        throws IOException, JsonProcessingException {

        gen.writeString(formatter.print(value));
    }
}