package com.teamdev.wikiformatting.web.utils;

import com.google.gson.Gson;

public final class JsonHelper {

    private static final Gson GSON = new Gson();

    public static String toJson(Object data) {
        return GSON.toJson(data);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }
}
