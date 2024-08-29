package com.sum.sampleadapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author  LiuJiang
 * Desc:
 */
class ViewHolder<V: ViewBinding>(val binding: V) : RecyclerView.ViewHolder(binding.root) {
}