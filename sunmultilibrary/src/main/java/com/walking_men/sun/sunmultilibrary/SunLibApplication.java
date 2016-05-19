package com.walking_men.sun.sunmultilibrary;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhai on 16/5/9.
 */
public abstract class SunLibApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        SunWorkLibHellpter.initImageSdPath(sdPath());
    }

    public abstract String sdPath();
}
