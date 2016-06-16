package com.walking_men.sun.sunmultilibrary.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by walkingMen on 2016/6/16.
 */
public class DateSerializer implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(Date date, Type arg1, JsonSerializationContext arg2) {
        return new JsonPrimitive(date.getTime());
    }
}
