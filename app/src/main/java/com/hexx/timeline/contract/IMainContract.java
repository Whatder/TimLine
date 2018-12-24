package com.hexx.timeline.contract;

import com.hexx.timeline.base.IContract;

/**
 * Created by Hexx on 2018/12/7 17:00
 * Desc：
 */
public interface IMainContract {
    interface IMainView extends IContract.IBaseView {
        void succ(String msg);

        void del(int index);
    }

    interface IMainBaseModel extends IContract.IBaseModel {
        String getInfo(String str);
    }
}
