package com.hexx.timeline.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hexx.timeline.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hexx on 2018/11/5 13:39
 * Desc：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @BindView(R.id.toolbar_common)
    Toolbar mToolbarCommon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initToolbar();
    }

    /**
     * 初始化toolbar（如果有）
     */
    private void initToolbar() {
        if (mToolbarCommon != null) {
            setSupportActionBar(mToolbarCommon);
            View decorView = getWindow().getDecorView();
            //状态栏透明
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            mToolbarCommon.setFitsSystemWindows(true);
            //设置标题
            if (getToolbarTitle() != null) setTitle(getToolbarTitle());
        }
    }

    protected String getToolbarTitle() {
        return null;
    }

    protected abstract int getLayoutId();
}
