package com.walking_men.sun.sunmultilibrary.bindingcollectionadapter;

import android.content.res.ColorStateList;
import android.databinding.BindingConversion;
import android.databinding.ObservableInt;
import android.graphics.drawable.Drawable;

import com.walking_men.sun.sunmultilibrary.SunLibApplication;


/**
 * Created by zhai on 15/11/17.
 */
public class BindingConversionUtils {

    @BindingConversion
    public static Drawable convertDrawableToDrawable(int drawableId) {
        if (drawableId > 0) {
            return SunLibApplication.context.getResources().getDrawable(drawableId);
        }
        return null;
    }

    @BindingConversion
    public static ColorStateList convertColorIdToColorStateList(int colorId) {
        if (colorId > 0) {
            return SunLibApplication.context.getResources().getColorStateList(colorId);
        }
        return null;
    }

//    @BindingConversion
//    public static CameraView.FlashMode convertBooleanToFlashMode(boolean isopen) {
//        if (isopen) {
//            return CameraView.FlashMode.ON;
//        } else {
//            return CameraView.FlashMode.OFF;
//        }
//    }

    @BindingConversion
    public static String convertIntToStringMode(ObservableInt integer) {
        return String.valueOf(integer.get());
    }

//    @BindingConversion
//    public static String convertIdToStringMode(int id) {
//        return Global.getContext().getString(id);
//    }
}
