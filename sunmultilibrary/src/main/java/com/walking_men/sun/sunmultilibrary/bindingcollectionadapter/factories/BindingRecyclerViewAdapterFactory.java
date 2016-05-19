package com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.factories;


import android.support.v7.widget.RecyclerView;

import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.BindingRecyclerViewAdapter;
import com.walking_men.sun.sunmultilibrary.bindingcollectionadapter.ItemViewArg;


public interface BindingRecyclerViewAdapterFactory {
    <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg);

    BindingRecyclerViewAdapterFactory DEFAULT = new BindingRecyclerViewAdapterFactory() {
        @Override
        public <T> BindingRecyclerViewAdapter<T> create(RecyclerView recyclerView, ItemViewArg<T> arg) {
            return new BindingRecyclerViewAdapter<>(arg);
        }
    };
}
