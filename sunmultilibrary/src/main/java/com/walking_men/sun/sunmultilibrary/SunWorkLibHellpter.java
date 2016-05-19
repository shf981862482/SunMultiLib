package com.walking_men.sun.sunmultilibrary;

import android.app.Activity;

import com.walking_men.sun.sunmultilibrary.utils.DeviceInfo;
import com.walking_men.sun.sunmultilibrary.utils.DisplayUtil;
import com.walking_men.sun.sunmultilibrary.utils.FileUtils;


/**
 * Created by zhai on 16/5/8.
 */
public class SunWorkLibHellpter {

    public static void initImageSdPath(String sdPath) {
        FileUtils.initImageSdPath(sdPath);
    }

    /**
     * 在闪屏幕中的初始化
     *
     * @param activity
     */
    public static void splashInit(Activity activity) {
        DisplayUtil.init(activity);
        DeviceInfo.init(activity, activity);//初始化设备信息
    }

}
