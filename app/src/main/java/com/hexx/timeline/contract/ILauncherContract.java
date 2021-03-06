package com.hexx.timeline.contract;

import com.hexx.timeline.base.IContract;

/**
 * Created by Hexx on 2018/12/14 18:47
 * Desc：
 */
public interface ILauncherContract {
    interface ILauncherView extends IContract.IBaseView {
        void startApp();

        void startError();
    }

    interface ILauncherBaseModel extends IContract.IBaseModel {
        boolean radon(int limit);
    }
}
