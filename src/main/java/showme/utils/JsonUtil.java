package showme.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class JsonUtil {


    private static Gson gson = new GsonBuilder().serializeNulls().create();

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> T fromJson(String jsonString, Type type) {
        return gson.fromJson(jsonString, type);
    }

    public static <T> String toJson(T object) {
        return gson.toJson(object);
    }
}
