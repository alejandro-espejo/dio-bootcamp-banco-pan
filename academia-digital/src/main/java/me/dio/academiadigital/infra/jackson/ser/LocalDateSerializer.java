package me.dio.academiadigital.infra.jackson.ser;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import me.dio.academiadigital.infra.utils.JavaTimeUtils;

public class LocalDateSerializer extends StdSerializer<LocalDate> {

	private static final long serialVersionUID = 1L;

	public LocalDateSerializer() {
		super(LocalDate.class);
	}

	@Override
	public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(value.format(JavaTimeUtils.LOCAL_DATE_FORMATTER));
	}
}
