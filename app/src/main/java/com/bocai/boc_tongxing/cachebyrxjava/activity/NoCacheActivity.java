package com.bocai.boc_tongxing.cachebyrxjava.activity;

import android.app.Application;
import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bocai.boc_tongxing.cachebyrxjava.MyApplication;
import com.bocai.boc_tongxing.cachebyrxjava.R;
import com.bocai.boc_tongxing.cachebyrxjava.bean.GitHubClient;
import com.bocai.boc_tongxing.cachebyrxjava.bean.Repo;
import com.bocai.boc_tongxing.cachebyrxjava.databinding.ActivityNoCacheBinding;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NoCacheActivity extends AppCompatActivity {

    @Inject
    Application mApplication;
    @Inject
    GitHubClient mGitHubClient;

    private ActivityNoCacheBinding binding;
    private ProgressDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_no_cache);

        ((MyApplication) getApplication()).getApiComponent().inject(this);
        waitDialog = ProgressDialog.show(this, "正在加载", "请稍等...");
        mGitHubClient.getRepos("EthanCo")
                .delay(3, TimeUnit.SECONDS) //延迟3秒，模拟效果
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(ArrayList<Repo> repos) {
        binding.tvInfo.setText(repos.get(0).getName());
        waitDialog.dismiss();
    }

    private void onError(Throwable throwable) {
        Log.e("zhk-NoCacheActivity", "onError: " + throwable.getMessage());
        waitDialog.dismiss();
    }
}
