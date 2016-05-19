package com.walking_men.sun.sunmultilibrary.rxandroid.schedulers;

import android.os.Handler;

import com.walking_men.sun.sunmultilibrary.rxandroid.plugins.RxAndroidPlugins;

import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by zhai on 16/3/18.
 */
public class HandlerScheduler extends Scheduler {
    /** Create a {@link Scheduler} which uses {@code handler} to execute actions. */
    public static HandlerScheduler from(Handler handler) {
        if (handler == null) throw new NullPointerException("handler == null");
        return new HandlerScheduler(handler);
    }

    private final Handler handler;

    HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public Worker createWorker() {
        return new HandlerWorker(handler);
    }

    static class HandlerWorker extends Worker {

        private final Handler handler;

        private final CompositeSubscription compositeSubscription = new CompositeSubscription();

        HandlerWorker(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void unsubscribe() {
            compositeSubscription.unsubscribe();
        }

        @Override
        public boolean isUnsubscribed() {
            return compositeSubscription.isUnsubscribed();
        }

        @Override
        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            if (compositeSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }

            action = RxAndroidPlugins.getInstance().getSchedulersHook().onSchedule(action);

            final ScheduledAction scheduledAction = new ScheduledAction(action);
            scheduledAction.addParent(compositeSubscription);
            compositeSubscription.add(scheduledAction);

            handler.postDelayed(scheduledAction, unit.toMillis(delayTime));

            scheduledAction.add(Subscriptions.create(new Action0() {
                @Override
                public void call() {
                    handler.removeCallbacks(scheduledAction);
                }
            }));

            return scheduledAction;
        }

        @Override
        public Subscription schedule(final Action0 action) {
            return schedule(action, 0, TimeUnit.MILLISECONDS);
        }
    }
}
