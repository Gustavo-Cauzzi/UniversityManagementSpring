package com.gestao.utils;

import java.util.HashMap;

public class GenericResponse extends HashMap<String, Object> {
    public static GenericResponse create() {
        return new GenericResponse();
    }

    @Override
    public GenericResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
