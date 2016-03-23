package com.bocai.boc_tongxing.cachebyrxjava;

import android.app.Application;

import com.bocai.boc_tongxing.cachebyrxjava.component.ApiComponent;
import com.bocai.boc_tongxing.cachebyrxjava.component.DaggerApiComponent;
import com.bocai.boc_tongxing.cachebyrxjava.model.ApiModule;

/**
 * @Description TODO
 * Created by EthanCo on 2016/3/23.
 */
public class MyApplication extends Application {
    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder().apiModule(new ApiModule(this)).build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
