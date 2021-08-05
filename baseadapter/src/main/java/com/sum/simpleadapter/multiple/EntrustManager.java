package com.sum.simpleadapter.multiple;

import java.util.ArrayList;
import java.util.List;

import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * Desc:
 */
public class EntrustManager<T> {
    protected List<Entrust<ViewBinding, T>> container = new ArrayList<>();

    /**
     * 添加
     * @param item
     */
    public void add(Entrust<ViewBinding, T> item) {
        container.add(item);
    }

    /**
     * 获取当前的type
     * @param t
     * @return
     */
    public int getViewTypeByPosition(T t) {
        for (int i = 0; i < container.size(); i++) {
            Entrust<ViewBinding, T> item = container.get(i);
            if (item.isThisType(t)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 根据viewType获取child
     * @param viewType
     * @return
     */
    public Entrust<ViewBinding, T> getByViewType(int viewType) {
        return container.get(viewType);
    }

    /**
     * 获取当前对象的child
     * @param t
     * @return
     */
    public Entrust<ViewBinding, T> getByItem(T t) {
        return container.get(getViewTypeByPosition(t));
    }
} 
