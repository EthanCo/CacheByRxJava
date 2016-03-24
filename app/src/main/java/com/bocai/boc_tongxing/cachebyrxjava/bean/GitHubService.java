package com.bocai.boc_tongxing.cachebyrxjava.bean;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by EthanCo on 2016/3/23.
 */
public interface GitHubService {
    String BASE_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Observable<ArrayList<Repo>> getRepos(@Path("user") String user);
}