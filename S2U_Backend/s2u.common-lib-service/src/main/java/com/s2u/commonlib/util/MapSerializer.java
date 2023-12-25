package com.s2u.commonlib.util;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MapSerializer {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private MapSerializer() {

	}

	static {
		MAPPER.registerModule(new JavaTimeModule());
		MAPPER.registerModule(new Jdk8Module());
	}

	public static <T> Map<String, Object> toMap(T t) {
		return MAPPER.convertValue(t, Map.class);
	}

	public static <T> T fromMap(final Map<String, Object> requestJsonMap, Class<T> t) {
		return MAPPER.convertValue(requestJsonMap, t);
	}
}
