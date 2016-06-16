package com.walking_men.sun.sunmultilibrary.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by walkingMen on 2016/6/16.
 * Gson解析，类型规范
 */
public class GsonUtils {
    public static String toJsonString(IEntity clazz,Type typeOfSrc) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG).create();
        String Str = gson.toJson(clazz,typeOfSrc);
        return Str;
    }

    public static String toJsonString(IEntity clazz) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG).create();
        String Str = gson.toJson(clazz);
        return Str;
    }

    public static <T extends IEntity> T fromJson(String jsonData, Class<T> tClass) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeSerializer()).setDateFormat(DateFormat.LONG).create();
        T user = gson.fromJson(jsonData, tClass);
        return user;
    }

    public static <T extends IEntity> T fromJson(String jsonData, Type type) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeSerializer()).setDateFormat(DateFormat.LONG).create();
        T user = gson.fromJson(jsonData, type);
        return user;
    }

    public static <T extends IEntity> List<T> fromJsonArray(String jsonData, Class<T> tClass) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeSerializer()).setDateFormat(DateFormat.LONG).create();
        List<T> resultList = gson.fromJson(jsonData, new ListParameterizedType(tClass));
        return resultList;
    }


    public static <T> T fromJson(byte[] jsonBytes, Type type) {
        T obj = null;
        if (jsonBytes != null) {
            Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeSerializer()).setDateFormat(DateFormat.LONG).create();
            String jsonStr = new String(jsonBytes);
            try {
                obj = gson.fromJson(jsonStr, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    private static class ListParameterizedType implements ParameterizedType {

        private Type type;

        private ListParameterizedType(Type type) {
            this.type = type;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{type};
        }

        @Override
        public Type getRawType() {
            return ArrayList.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }

        // implement equals method too! (as per javadoc)
    }
}
