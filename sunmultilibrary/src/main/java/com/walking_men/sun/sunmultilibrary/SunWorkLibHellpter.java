package com.walking_men.sun.sunmultilibrary;

import android.app.Activity;

import com.walking_men.sun.sunmultilibrary.utils.DeviceInfo;
import com.walking_men.sun.sunmultilibrary.utils.SunDisplayUtil;
import com.walking_men.sun.sunmultilibrary.utils.FileUtils;
import com.walking_men.sun.sunmultilibrary.utils.SunLogger;


/**
 * Created by zhai on 16/5/8.
 */
public class SunWorkLibHellpter {
    private volatile static SunWorkLibHellpter mInstance;

    public static SunWorkLibHellpter getInstance() {
        if (mInstance == null) {
            synchronized (SunWorkLibHellpter.class) {
                if (mInstance == null) {
                    mInstance = new SunWorkLibHellpter();
                }
            }
        }
        return mInstance;
    }

    private SunWorkLibHellpter() {

    }

    /**
     * @param sdImagePath
     */
    public SunWorkLibHellpter setSdCardImagePath(String sdImagePath) {
        FileUtils.initImageSdPath(sdImagePath);
        return this;
    }

    public void setIsSHowLog(String tag, boolean isSHowLog) {
        SunLogger.init(tag, isSHowLog);
    }

    /**
     * 在闪屏幕中的初始化
     *
     * @param activity
     */
    public void splashInit(Activity activity) {
        DeviceInfo.init(activity, activity);//初始化设备信息
    }

}
