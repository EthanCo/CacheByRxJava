package com.bocai.boc_tongxing.cachebyrxjava.component;

import com.bocai.boc_tongxing.cachebyrxjava.activity.CacheActivity;
import com.bocai.boc_tongxing.cachebyrxjava.activity.NoCacheActivity;
import com.bocai.boc_tongxing.cachebyrxjava.model.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @Description TODO
 * Created by EthanCo on 2016/3/23.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(CacheActivity activity);

    void inject(NoCacheActivity activity);
}
