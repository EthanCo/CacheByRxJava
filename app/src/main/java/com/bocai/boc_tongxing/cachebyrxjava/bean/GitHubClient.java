package com.bocai.boc_tongxing.cachebyrxjava.bean;

import java.util.ArrayList;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * @Description TODO
 * Created by EthanCo on 2016/3/23.
 */
public class GitHubClient {
    private GitHubService mGitHubService;

    public GitHubClient() {
        mGitHubService = new Retrofit.Builder()
                .baseUrl(GitHubService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(GitHubService.class);
    }

    public Observable<ArrayList<Repo>> getRepos(String userName) {
        return mGitHubService.getRepos(userName);
    }
}
