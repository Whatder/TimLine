package com.hexx.timeline;

import com.hexx.timeline.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getToolbarTitle() {
        return "时间线";
    }
}
