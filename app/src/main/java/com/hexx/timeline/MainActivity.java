package com.hexx.timeline;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.hexx.timeline.base.BaseActivity;
import com.hexx.timeline.contract.IMainContract;
import com.hexx.timeline.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IMainView {

    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected String getToolbarTitle() {
        return "时间线";
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        mPresenter.getInfo();
    }

    @Override
    public void succ(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }
}
