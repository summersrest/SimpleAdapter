package com.sum.simpleadapter.multiple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sum.simpleadapter.base.ViewHolder;

import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * Desc:
 */
public interface Entrust<V extends ViewBinding, T> {
    ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup parent);

    boolean isThisType(T t);

    void onBind(Context context, ViewHolder<V> holder, T item, int position);
} 
