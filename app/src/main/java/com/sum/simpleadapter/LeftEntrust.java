package com.sum.simpleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sum.simpleadapter.base.ViewHolder;
import com.sum.simpleadapter.multiple.Entrust;
import com.sum.simpleadapter.databinding.ItemMainLeftBinding;

import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * created at: 2021/8/5 17:02
 * Desc:
 */
public class LeftEntrust implements Entrust<ItemMainLeftBinding, ItemBean> {
    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup parent) {
        return ItemMainLeftBinding.inflate(layoutInflater, parent, false);
    }

    @Override
    public boolean isThisType(ItemBean itemBean) {
       return (itemBean.getType() == 0);
    }

    @Override
    public void onBind(Context context, ViewHolder<ItemMainLeftBinding> holder, ItemBean item, int position) {
        holder.binding.tvTextLeft.setText(item.getTitie());
    }
}
