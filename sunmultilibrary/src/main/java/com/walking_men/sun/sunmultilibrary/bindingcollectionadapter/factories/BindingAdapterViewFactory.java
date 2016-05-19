package com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.factories;

import android.widget.AdapterView;

import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.BindingListViewAdapter;
import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.ItemViewArg;


public interface BindingAdapterViewFactory {

    public <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg);

    public BindingAdapterViewFactory DEFAULT = new BindingAdapterViewFactory() {
        @Override
        public <T> BindingListViewAdapter<T> create(AdapterView adapterView, ItemViewArg<T> arg) {
            return new BindingListViewAdapter<>(arg);
        }
    };

}
