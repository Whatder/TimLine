package com.hexx.timeline.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
public abstract class BaseActivity<P extends BasePresenter>
        extends AppCompatActivity implements IContract.IBaseView {
    @Nullable
    @BindView(R.id.toolbar_common)
    Toolbar mToolbarCommon;

    protected P mPresenter;
    private AlertDialog mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = getPresenter();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initToolbar();
    }

    /**
     * 初始化toolbar（如果有）
     */
    private void initToolbar() {
        View decorView = getWindow().getDecorView();
        //状态栏透明
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        if (mToolbarCommon != null) {
            setSupportActionBar(mToolbarCommon);
            mToolbarCommon.setFitsSystemWindows(true);
            //设置标题
            if (getToolbarTitle() != null) setTitle(getToolbarTitle());
            //设置背景色
            mToolbarCommon.setBackgroundResource(getToolbarBackground());
            //设置标题颜色
            mToolbarCommon.setTitleTextColor(getResources().getColor(getToolbarTitleColor()));
        }
    }

    /**
     * @return 标题
     */
    protected String getToolbarTitle() {
        return null;
    }

    /**
     * @return 标题颜色
     */
    protected int getToolbarTitleColor() {
        return R.color.grey50;
    }

    /**
     * @return toolbar背景res
     */
    protected int getToolbarBackground() {
        return R.drawable.bg_toolbar;
    }

    /**
     * @return 布局
     */
    protected abstract int getLayoutId();

    protected abstract P getPresenter();

    @Override
    public void showLoading() {
        if (mLoading == null) {
            mLoading = new AlertDialog.Builder(this).setMessage("Loading...").create();
        }
        mLoading.show();
    }

    @Override
    public void hideLoading() {
        if (mLoading != null && mLoading.isShowing()) {
            mLoading.dismiss();
        }
    }
}
