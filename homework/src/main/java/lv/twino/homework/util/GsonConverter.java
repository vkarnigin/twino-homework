package lv.twino.homework.util;

public interface GsonConverter {

    String convertToJson(Object payload);

    <T> T convertFromJson(String json, Class<T> clazz);

}
