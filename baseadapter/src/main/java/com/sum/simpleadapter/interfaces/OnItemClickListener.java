package com.sum.simpleadapter.interfaces;

import android.view.View;

/**
 * @author liujiang
 * Desc:
 */
public interface OnItemClickListener<T> {
    void onItemClick(View view, T item, int position);

    default boolean onItemLongClick(View view, T item, int position) {
        return false;
    }
}
