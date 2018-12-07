package com.hexx.timeline.contract;

import com.hexx.timeline.base.IContract;

/**
 * Created by Hexx on 2018/12/7 17:00
 * Desc：
 */
public interface IMainContract {
    interface IMainView extends IContract.IBaseView, IContract.IModel {
        void succ(String msg);
    }

    interface IMainModel extends IContract.IModel {
        String getInfo(String str);
    }
}
