package com.walking_men.sun.sunmultilibrary.rxandroid.rxglid;

import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by zhai on 16/5/4.
 */
public class RxGlide {

    public static Observable<GlideBitmapDrawable> afterGlideRequestListener(DrawableTypeRequest<?> request) {
        if (null == request) {
            return Observable.empty();
        }
        return Observable.create(new GlideAfterRequestOnSubscribe(request))
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<GlideBitmapDrawable> afterGlideRequestListener(DrawableTypeRequest<?> request, ImageView imageView) {
        if (null == request) {
            return Observable.empty();
        }
        return Observable.create(new GlideAfterRequestOnSubscribe(request, imageView))
                .subscribeOn(AndroidSchedulers.mainThread());
    }
}