package com.sum.sampleadapter.multiple

import androidx.viewbinding.ViewBinding

/**
 * @author  LiuJiang
 * Desc:
 */
class EntrustManager<T> {
    private val container = mutableListOf<Entrust<*, T>>()

    /**
     * 添加
     */
    fun add(item: Entrust<*, T>) = container.add(item)

    /**
     * 获取当前的viewType类型
     */
    fun getViewType(t: T): Int {
        container.forEachIndexed { index, entrust ->
            if (entrust.isThisType(t)) return index
        }
        return 0
    }

    /**
     * 根据viewType获取ViewHolder
     */
    fun getViewHolderByViewType(viewType: Int): Entrust<ViewBinding, T> = container[viewType] as Entrust<ViewBinding, T>

    /**
     * 获取当前item获取ViewHolder
     */
    fun getViewHolderByItem(t: T): Entrust<ViewBinding, T> = container[getViewType(t)] as Entrust<ViewBinding, T>
}