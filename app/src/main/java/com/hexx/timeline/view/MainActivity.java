package com.hexx.timeline.view;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

import com.hexx.timeline.R;
import com.hexx.timeline.base.BaseActivity;
import com.hexx.timeline.contract.IMainContract;
import com.hexx.timeline.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainContract.IMainView {

    @BindView(R.id.btn)
    Button mBtn;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

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
}
