package com.hexx.timeline.model;

import com.hexx.timeline.contract.ILauncherContract;

/**
 * Created by Hexx on 2018/12/14 19:07
 * Desc：
 */
public class LauncherBaseModel implements ILauncherContract.ILauncherBaseModel {

    @Override
    public boolean radon(int limit) {
        return Math.random() * 10 > limit;
    }
}
