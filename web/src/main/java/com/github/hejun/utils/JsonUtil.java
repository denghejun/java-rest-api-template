package com.github.hejun.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    public static String toJsonWithList(List<?> list) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }

    public static String toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return (T) mapper.readValue(json, clazz);
    }

    public static <T> List<T> toList(String json, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        return (List<T>) mapper.readValue(json, type);
    }
}
