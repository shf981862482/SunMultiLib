package com.walking_men.sun.sunmultilibrary.http.builder;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.walking_men.sun.sunmultilibrary.http.OkHttpWork;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by zhai on 16/1/18.
 */
public class MapParamsConverter {

    public final static String FILE_KEY = "file";

    public static RequestBody map2ForBody(Map<String, Object> map) {
        FormBody.Builder builder = new FormBody.Builder();
        if (map == null || map.size() == 0) return builder.build();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            if (key != null && value != null) {
                builder.add(key, value);
            }
        }
        return builder.build();
    }

    /**
     * 用于FILE上传
     *
     * @param map
     * @return
     */
    public static RequestBody map2ForMultBody(Map<String, Object> map) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (map == null || map.size() == 0) return builder.build();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (String) entry.getValue();
            if (!key.equals(FILE_KEY)) {
                builder.addFormDataPart(entry.getKey(), value);
            } else {
                File uploadFile = new File((String) entry.getValue());
                builder.addFormDataPart(FILE_KEY, uploadFile.getName(), RequestBody.create(null, uploadFile));
            }
        }
        return builder.build();
    }

    public static RequestBody map2ForJSON(Map<String, Object> map) {
        String jsonStirng = "";

        Gson gson = new GsonBuilder().create();
        if (map.size() > 0) {
            jsonStirng = gson.toJson(map);
        }
        RequestBody body = RequestBody.create(OkHttpWork.JSON, jsonStirng);
        return body;
    }


}
