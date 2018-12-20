package com.hexx.timeline.presenter;

import com.hexx.timeline.base.BasePresenter;
import com.hexx.timeline.contract.ILauncherContract;
import com.hexx.timeline.model.LauncherBaseModel;

/**
 * Created by Hexx on 2018/12/14 18:49
 * Desc：
 */
public class LauncherPresenter extends BasePresenter<ILauncherContract.ILauncherView, ILauncherContract.ILauncherBaseModel> {
    public LauncherPresenter(ILauncherContract.ILauncherView view) {
        super(view);
    }

    @Override
    protected ILauncherContract.ILauncherBaseModel attachModel() {
        return new LauncherBaseModel();
    }

    public void checkRadon() {
        boolean flag = mModel.radon(2);
        if (flag) {
            mView.startApp();
        } else {
            mView.startError();
        }
    }
}
