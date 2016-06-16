package com.walking_men.sun.sunmultilibrary.rxandroid;

/**
 * Created by walkingMen on 2016/6/16.
 */

import com.walking_men.sun.sunmultilibrary.utils.Global;

import java.util.concurrent.atomic.AtomicReference;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by zhai on 16/6/14.
 */
public class SunSchedulers {
    private static final AtomicReference<SunSchedulers> INSTANCE = new AtomicReference<>();
    private final Scheduler workThreadScheduler;

    private static SunSchedulers getInstance() {
        for (; ; ) {
            SunSchedulers current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new SunSchedulers();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

    private SunSchedulers() {
        workThreadScheduler = AndroidSchedulers.from(Global.getWorkThreadLooper());
    }

    public static Scheduler workThread() {
        return getInstance().workThreadScheduler;
    }
}
