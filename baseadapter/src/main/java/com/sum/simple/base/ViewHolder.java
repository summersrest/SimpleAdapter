package com.sum.simple.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * Desc:
 */
public class ViewHolder<V extends ViewBinding> extends RecyclerView.ViewHolder {
    public V binding;

    public ViewHolder(V item) {
        super(item.getRoot());
        binding = item;
    }
}
