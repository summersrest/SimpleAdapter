package com.sum.simple.interfaces;

import android.view.View;


/**
 * @author liujiang
 * Desc:
 */
public abstract class SimpleOnItemClickListener<T> implements OnItemClickListener<T> {
    @Override
    public boolean onItemLongClick(View view, T item, int position) {
        return false;
    }
}
