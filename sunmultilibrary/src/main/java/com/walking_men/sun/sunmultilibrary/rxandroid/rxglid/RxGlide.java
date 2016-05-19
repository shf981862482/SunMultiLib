package com.walking_men.sun.sunmultilibrary.rxandroid.rxglid;

import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;

import rx.Observable;

/**
 * Created by zhai on 16/5/4.
 */
public class RxGlide {

    public static Observable<GlideBitmapDrawable> afterGlideRequestListener(DrawableTypeRequest<String> request) {
        if (null == request) {
            return Observable.empty();
        }
        return Observable.create(new GlideAfterRequestOnSubscribe(request));
    }

    public static Observable<GlideBitmapDrawable> afterGlideRequestListener(DrawableTypeRequest<String> request, ImageView imageView) {
        if (null == request) {
            return Observable.empty();
        }
        return Observable.create(new GlideAfterRequestOnSubscribe(request, imageView));
    }
}