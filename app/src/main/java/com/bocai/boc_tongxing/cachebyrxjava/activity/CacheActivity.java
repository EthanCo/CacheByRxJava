package com.bocai.boc_tongxing.cachebyrxjava.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bocai.boc_tongxing.cachebyrxjava.R;
import com.bocai.boc_tongxing.cachebyrxjava.databinding.ActivityCacheBinding;

public class CacheActivity extends AppCompatActivity {

    private ActivityCacheBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_cache);
    }
}
