package com.walking_men.sun.sunmultilibrary.weiget;

import android.view.View;

import com.walking_men.sun.sunmultilibrary.utils.ClickUtil;

/**
 * Created by walkingMen on 2016/7/12.
 */
public abstract class OnSignClickListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if (!ClickUtil.isFastDoubleClick()) {
            onClickListener(v);
        }
    }

    public abstract void onClickListener(View v);
}
