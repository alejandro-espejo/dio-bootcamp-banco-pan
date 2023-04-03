package me.dio.academiadigital.infra.jackson.deser;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import me.dio.academiadigital.infra.utils.JavaTimeUtils;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	public LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		 return LocalDateTime.parse(p.readValueAs(String.class), JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER);
	}
}
