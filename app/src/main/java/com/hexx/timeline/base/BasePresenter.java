package com.hexx.timeline.base;

/**
 * Created by Hexx on 2018/12/7 16:52
 * Desc：
 */
public abstract class BasePresenter<V extends IContract.IBaseView, M extends IContract.IBaseModel> implements IPresenter {

    protected M mModel;
    protected V mView;


    public BasePresenter(V view) {
        mView = view;
        mModel = attachModel();
    }

    protected abstract M attachModel();
}
