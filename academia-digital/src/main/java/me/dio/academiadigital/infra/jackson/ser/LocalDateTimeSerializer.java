package me.dio.academiadigital.infra.jackson.ser;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import me.dio.academiadigital.infra.utils.JavaTimeUtils;

public class LocalDateTimeSerializer extends StdSerializer<LocalDateTime> {

	private static final long serialVersionUID = 1L;

	public LocalDateTimeSerializer() {
		super(LocalDateTime.class);
	}

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.format(JavaTimeUtils.LOCAL_DATE_TIME_FORMATTER));
	}

}
