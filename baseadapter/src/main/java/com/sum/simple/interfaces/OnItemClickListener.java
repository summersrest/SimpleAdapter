package com.sum.simple.interfaces;

import android.view.View;

/**
 * @author liujiang
 * Desc:
 */
public interface OnItemClickListener<T> {
    void onItemClick(View view, T item, int position);

    boolean onItemLongClick(View view, T item, int position);
}
