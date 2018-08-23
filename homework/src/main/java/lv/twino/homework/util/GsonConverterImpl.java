package lv.twino.homework.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonConverterImpl implements GsonConverter {

    private Gson gson;

    private GsonConverterImpl() {
        gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
    }

    private static class SingletonHolder {
        private static GsonConverterImpl instance = new GsonConverterImpl();
    }

    public static GsonConverterImpl getInstance() {
        return SingletonHolder.instance;
    }

    public String convertToJson(Object payload) {
        return gson.toJson(payload);
    }

    public <T> T convertFromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
