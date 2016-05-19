package com.walking_men.sun.sunmultilibrary.http.builder;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Map;


/**
 * Created by xiaomeng.zhai on 2014/6/26.
 */
public interface URLBuilder {

    public static final byte REQ_TYPE_KV = 0;
    public static final byte REQ_TYPE_JSON = 1;
    public static final byte REQ_TYPE_FILE = 2;

    public void parse(Path path, Map<String, Field> cachedFields, ParamEntity entity) throws IllegalAccessException;

    public String getUrl();

    public Map<String, Object> getParams();

    public Map<String, Object> getCacheKeyParams();

    public byte getReqType();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Path {
        public String host() default "";

        public String url();

        public String[] sign() default "";

        public String[] encrypt() default "";

        public Class<? extends URLBuilder> builder() default DefaultURLBuilder.class;
    }
}
