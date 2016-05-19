package com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.factories;

import android.support.v4.view.ViewPager;

import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.BindingViewPagerAdapter;
import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.ItemViewArg;


public interface BindingViewPagerAdapterFactory {
    <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg);

    BindingViewPagerAdapterFactory DEFAULT = new BindingViewPagerAdapterFactory() {
        @Override
        public <T> BindingViewPagerAdapter<T> create(ViewPager viewPager, ItemViewArg<T> arg) {
            return new BindingViewPagerAdapter<>(arg);
        }
    };

}
