package com.hexx.timeline.model;

import com.hexx.timeline.contract.IMainContract;

/**
 * Created by Hexx on 2018/12/7 17:04
 * Desc：
 */
public class MainModel implements IMainContract.IMainModel {
    @Override
    public String getInfo(String str) {
        return str + " created";
    }
}
