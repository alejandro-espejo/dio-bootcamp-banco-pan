package me.dio.academiadigital.infra.jackson.deser;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import me.dio.academiadigital.infra.utils.JavaTimeUtils;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

	private static final long serialVersionUID = 1L;

	protected LocalDateDeserializer() {
		super(LocalDate.class);
	}

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		return LocalDate.parse(p.readValueAs(String.class), JavaTimeUtils.LOCAL_DATE_FORMATTER);
	}

}
