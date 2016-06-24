package com.walking_men.sun.sunmultilibrary.utils;

import android.content.Context;
import android.view.WindowManager;

import java.lang.reflect.Field;

import com.walking_men.sun.sunmultilibrary.SunLibApplication;


public class SunDisplayUtil {

    private static int mScreenWidth;
    private static int mScreenHeight;
    public static int contentTop;//状态栏高

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) Global.getContext().getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    public static int getScreenWidth() {
        if (0 == mScreenWidth) {
            WindowManager wm = (WindowManager) Global.getContext().getSystemService(Context.WINDOW_SERVICE);
            mScreenWidth = wm.getDefaultDisplay().getWidth();
        }
        return mScreenWidth;
    }

    public static int getScreenHeight() {
        if (0 == mScreenHeight) {
            WindowManager wm = (WindowManager) Global.getContext().getSystemService(Context.WINDOW_SERVICE);
            mScreenHeight = wm.getDefaultDisplay().getHeight();
        }
        return mScreenHeight;
    }

    public static int contentTop() {
        if (0 == contentTop) {
            try {
                Class c = Class.forName("com.android.internal.R$dimen");
                Object obj = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = Integer.parseInt(field.get(obj).toString());
                contentTop =  Global.getContext().getResources().getDimensionPixelSize(x);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return contentTop;
    }


}

