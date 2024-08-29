package com.sum.sampleadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author  LiuJiang
 * Desc:
 */
abstract class SimpleAdapter<V : ViewBinding, T>(private val context: Context, private val data: List<T>) : RecyclerView.Adapter<ViewHolder<V>>() {
    /**
     * Item点击监听
     */
    private var onItemClick: ((position: Int, item: T) -> Unit)? = null

    fun setOnItemClickListener(onItemClick: (position: Int, item: T) -> Unit) {
        this.onItemClick = onItemClick
    }

    /**
     * Item长按监听
     */
    private var onLongClick: ((position: Int, item: T) -> Unit)? = null

    fun setOnLongClickListener(onLongClick: (position: Int, item: T) -> Unit) {
        this.onLongClick = onLongClick
    }

    /**
     * 获取viewBinding
     */
    protected abstract fun getViewBinding(viewType: Int, layoutInflater: LayoutInflater, parent: ViewGroup): V

    /**
     * 绑定组件
     */
    protected abstract fun onBind(context: Context, binding: V, position: Int, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<V> {
        val viewHolder = ViewHolder(getViewBinding(viewType, LayoutInflater.from(context), parent))
        setListener(viewHolder)
        return viewHolder
    }

    private fun setListener(viewHolder: ViewHolder<V>) {
        viewHolder.binding.root.setOnClickListener {
            if (null != onItemClick) {
                val position = viewHolder.adapterPosition
                onItemClick?.invoke(position, data[position])
            }
        }

        viewHolder.binding.root.setOnLongClickListener {
            if (null != onLongClick) {
                val position = viewHolder.adapterPosition
                onLongClick?.invoke(position, data[position])
            }
            false
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) {
        onBind(context, holder.binding, position, data[position])
    }
}