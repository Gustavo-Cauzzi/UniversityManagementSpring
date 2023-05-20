package com.gestao.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class Utils implements Serializable {
    private static final long serialVersionUID = -4168696455724087024L;

    public static String snakeCaseToCamelCase (String name) {
        name = name.toLowerCase(Locale.ROOT);
        while (name.contains("_")) {
            name = name.replaceFirst("_[A-Za-z_]",
                    String.valueOf(Character.toUpperCase(name.charAt(name.indexOf("_") + 1))));
        }
        return name;
    }

    public static String camelCaseToSnakeCase(final String name) {
        if (Objects.isNull(name)) {
            return "";
        }

        List<Character> chars = new ArrayList<>(name.length() * 2);

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                chars.add('_');
            }
            chars.add(c);
        }
        return chars.stream().map(String::valueOf).collect(Collectors.joining("")).toLowerCase();
    }
}
