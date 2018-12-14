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

    interface ILauncherModel extends IContract.IModel {
        boolean radon(int limit);
    }
}
