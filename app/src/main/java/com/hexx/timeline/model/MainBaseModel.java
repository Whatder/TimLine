package com.hexx.timeline.model;

import com.hexx.timeline.contract.IMainContract;

import java.util.Locale;

/**
 * Created by Hexx on 2018/12/7 17:04
 * Desc：
 */
public class MainBaseModel implements IMainContract.IMainBaseModel {
    @Override
    public String getInfo(String str) {
        return String.format(Locale.CHINA, "%s created-%d", str, (int) (Math.random() * 100));
    }
}
