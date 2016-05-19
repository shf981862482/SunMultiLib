package com.walking_men.sun.sunmultilibrary.http.callback;


import com.walking_men.sun.sunmultilibrary.http.responser.AbstractResponser;

/**
 * Created by zhai on 16/1/18.
 */
public interface NetworkCallback<T extends AbstractResponser> {

    public void onSucessed(T rsp);

    public void onFailed(int code, String msg);

}
