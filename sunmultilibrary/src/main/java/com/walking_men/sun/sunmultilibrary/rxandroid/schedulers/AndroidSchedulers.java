package com.walking_men.sun.sunmultilibrary.rxandroid.schedulers;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.walking_men.sun.sunmultilibrary.rxandroid.plugins.RxAndroidPlugins;

import rx.Scheduler;

/**
 * Created by zhai on 16/3/18.
 */
public class AndroidSchedulers {
    private AndroidSchedulers() {
        throw new AssertionError("No instances");
    }

    private static class WorkThreadSchedulerHolder {
        static HandlerThread workThread;

        static {
            workThread = new HandlerThread("AndroidSchedulersWorkThread");
            workThread.start();
        }

        static final Scheduler WORK_THREAD_SCHEDULER =
                new HandlerScheduler(new Handler(workThread.getLooper()));
    }


    // See https://github.com/ReactiveX/RxAndroid/issues/238
    // https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    private static class MainThreadSchedulerHolder {
        static final Scheduler MAIN_THREAD_SCHEDULER =
                new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    /**
     * A {@link Scheduler} which executes actions on the Android UI thread.
     */
    public static Scheduler mainThread() {
        Scheduler scheduler =
                RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        return scheduler != null ? scheduler : MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
    }

    /**
     * single thread
     *
     * @return
     */
    public static Scheduler ioThread() {
        return WorkThreadSchedulerHolder.WORK_THREAD_SCHEDULER;
    }
}
