package com.bocai.boc_tongxing.rxjavalib.rxutils;

import android.util.Log;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * @Description 自带Log 的 Subscriber
 * Created by EthanCo on 2016/3/18.
 */
public class LogSub<T> extends Subscriber<T> {
    private Action1<? super T> onNext;

    public LogSub(final Action1<? super T> onNext) {
        if (onNext == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        this.onNext = onNext;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e("Z-MSubScriber", "onError : " + e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onNext.call(t);
    }
}
