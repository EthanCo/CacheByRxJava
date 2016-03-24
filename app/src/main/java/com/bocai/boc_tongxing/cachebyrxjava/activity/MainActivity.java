package com.bocai.boc_tongxing.cachebyrxjava.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bocai.boc_tongxing.cachebyrxjava.R;
import com.bocai.boc_tongxing.cachebyrxjava.databinding.ActivityMainBinding;

import rx.Observer;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    final PublishSubject<String> subject = PublishSubject.create();
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnNoCache.setOnClickListener(v -> startActivity(new Intent(this, NoCacheActivity.class)));
        //binding.btnUseCache.setOnClickListener(v -> startActivity(new Intent(this, CacheActivity.class)));

        subject.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Observable Completed");
                Toast.makeText(getApplicationContext(), "s:" + s, Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnUseCache.setOnClickListener(v -> subject.onNext(String.valueOf("item" + (++i))));
    }
}
