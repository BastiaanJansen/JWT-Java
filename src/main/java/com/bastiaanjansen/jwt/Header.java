package com.bastiaanjansen.jwt;

import java.util.HashMap;
import java.util.Map;

public class Header extends HashMap<String, Object> {
    public static class Registered {
        static String TYPE = "typ";
        static String CONTENT_TYPE = "cty";
        static String ALGORITHM = "alg";
    }

    public Header() {
        setType("JWT");
    }

    public Header(Map<String, Object> map) {
        this();
        putAll(map);
    }

    public void setType(String type) {
        set(Registered.TYPE, type);
    }

    public String getType() {
        Object type = get(Registered.TYPE);
        return getString(type);
    }

    public void setContentType(String value) {
        set(Registered.CONTENT_TYPE, value);
    }

    public String getContentType() {
        Object contentType = get(Registered.CONTENT_TYPE);
        return getString(contentType);
    }

    public void setAlgorithm(String algorithm) {
        set(Registered.ALGORITHM, algorithm);
    }

    public String getAlgorithm() {
        Object algorithm = get(Registered.ALGORITHM);
        

        return getString(algorithm);
    }

    private String getString(Object object) {
        return object != null ? String.valueOf(object) : null;
    }

    private void set(String name, Object value) {
        if (name == null) throw new IllegalArgumentException("name cannot be null");
        if (value == null) throw new IllegalArgumentException("value cannot be null");

        put(name, value);
    }
}
