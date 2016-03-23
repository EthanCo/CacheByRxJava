package com.bocai.boc_tongxing.cachebyrxjava.model;

import android.app.Application;

import com.bocai.boc_tongxing.cachebyrxjava.bean.GitHubClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @Description TODO
 * Created by EthanCo on 2016/3/23.
 */
@Module
public class ApiModule {
    private Application mApplication;

    public ApiModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return mApplication;
    }

    @Provides
    @Singleton
    public GitHubClient provideGitHubClient(){
        return new GitHubClient();
    }
}
