package com.sum.sampleadapter.multiple

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 * @author  LiuJiang
 * Desc:
 */
abstract class Entrust<V: ViewBinding, T> {

    abstract fun getViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup): V

    abstract fun isThisType(t: T): Boolean

    abstract fun onBind(context: Context, binding: V, position: Int, item: T)
}