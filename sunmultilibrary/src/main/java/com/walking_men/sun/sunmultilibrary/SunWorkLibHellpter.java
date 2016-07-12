package com.walking_men.sun.sunmultilibrary;

import android.content.Context;

import com.walking_men.sun.sunmultilibrary.utils.DeviceInfo;
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

    public SunWorkLibHellpter setIsSHowLog(String tag, boolean isSHowLog) {
        SunLogger.init(tag, isSHowLog);
        return this;
    }

    /**
     * 在闪屏幕中的初始化
     *
     * @param context
     */
    public SunWorkLibHellpter initDeviceInfo(Context context) {
        DeviceInfo.init(context);//初始化设备信息
        return this;
    }

}
