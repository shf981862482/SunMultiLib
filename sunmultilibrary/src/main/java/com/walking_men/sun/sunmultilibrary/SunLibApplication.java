package com.walking_men.sun.sunmultilibrary;

import android.app.Application;
import android.content.Context;

import com.walking_men.sun.sunmultilibrary.utils.Global;

/**
 * Created by zhai on 16/5/9.
 */
public abstract class SunLibApplication extends Application {

    private static SunLibApplication sApplication;

    public static SunLibApplication getInstance() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SunWorkLibHellpter.getInstance()
                .setSdCardImagePath(initSDCardImagePath())
                .setIsSHowLog(initLogTag(), initIsLog());

        Global.setContext(getApplicationContext());
        Global.post2work(new Runnable() {
            @Override
            public void run() {
                SunWorkLibHellpter.getInstance()
                        .setSdCardImagePath(initSDCardImagePath())
                        .setIsSHowLog(initLogTag(), initIsLog());
            }
        });

    }

    public abstract String initSDCardImagePath();

    public abstract String initLogTag();

    public abstract boolean initIsLog();
}
