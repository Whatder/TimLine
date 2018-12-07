package com.hexx.timeline.presenter;

import com.hexx.timeline.base.BasePresenter;
import com.hexx.timeline.contract.IMainContract;
import com.hexx.timeline.model.MainModel;

/**
 * Created by Hexx on 2018/12/7 17:05
 * Desc：
 */
public class MainPresenter extends BasePresenter<IMainContract.IMainView, IMainContract.IMainModel> {
    public MainPresenter(IMainContract.IMainView view) {
        super(view);
        MainModel mainModel = new MainModel();
        attach(mainModel);
    }

    public void getInfo() {
        mView.showLoading();
        String result = mModel.getInfo("Info");
        mView.hideLoading();
        mView.succ(result);
    }
}
