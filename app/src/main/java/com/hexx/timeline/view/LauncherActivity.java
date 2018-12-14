package com.hexx.timeline.view;

import android.widget.Toast;

import com.hexx.timeline.R;
import com.hexx.timeline.base.BaseActivity;
import com.hexx.timeline.contract.ILauncherContract;
import com.hexx.timeline.presenter.LauncherPresenter;

import butterknife.OnClick;

/**
 * Created by Hexx on 2018/12/14 18:46
 * Desc：
 */
public class LauncherActivity extends BaseActivity<LauncherPresenter>
        implements ILauncherContract.ILauncherView {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected LauncherPresenter getPresenter() {
        return new LauncherPresenter(this);
    }

    @Override
    public void startApp() {
        MainActivity.start(this);
    }

    @Override
    public void startError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_start_app)
    public void onViewClicked() {
        mPresenter.checkRadon();
    }
}
