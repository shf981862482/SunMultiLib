package com.walking_men.sun.sunmultilibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

import com.walking_men.sun.sunmultilibrary.SunLibApplication;


public class DisplayUtil {

    private static int mScreenWidth;
    private static int mScreenHeight;

    /**
     * 全局的一些变量的初始化
     */
    public static void init(Activity activity) {
        WindowManager wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        mScreenWidth = wm.getDefaultDisplay().getWidth();
        mScreenHeight = wm.getDefaultDisplay().getHeight();
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = ((Activity) context).getWindowManager();
        return wm.getDefaultDisplay().getHeight();
    }

    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Context context) {
        WindowManager wm = ((Activity) context).getWindowManager();
        return wm.getDefaultDisplay().getWidth();
    }

    public static int getScreenWidth() {
        if (0 == mScreenWidth) {
            WindowManager wm = (WindowManager) SunLibApplication.context.getSystemService(Context.WINDOW_SERVICE);
            mScreenWidth = wm.getDefaultDisplay().getWidth();
        }
        return mScreenWidth;
    }

    public static int getScreenHeight() {
        if (0 == mScreenHeight) {
            WindowManager wm = (WindowManager) SunLibApplication.context.getSystemService(Context.WINDOW_SERVICE);
            mScreenHeight = wm.getDefaultDisplay().getHeight();
        }
        return mScreenHeight;
    }


}

