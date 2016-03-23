package com.bocai.boc_tongxing.cachebyrxjava.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bocai.boc_tongxing.cachebyrxjava.R;
import com.bocai.boc_tongxing.cachebyrxjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnNoCache.setOnClickListener(v -> startActivity(new Intent(this, NoCacheActivity.class)));
        binding.btnUseCache.setOnClickListener(v -> startActivity(new Intent(this, CacheActivity.class)));
    }
}
