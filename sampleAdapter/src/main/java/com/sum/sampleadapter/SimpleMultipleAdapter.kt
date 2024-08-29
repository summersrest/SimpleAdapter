package com.sum.sampleadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sum.sampleadapter.multiple.Entrust
import com.sum.sampleadapter.multiple.EntrustManager

/**
 * @author  LiuJiang
 * Desc:
 */
class SimpleMultipleAdapter<T>(val context: Context, val data: List<T>): RecyclerView.Adapter<ViewHolder<ViewBinding>>() {
    private val manager = EntrustManager<T>()

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

    override fun getItemViewType(position: Int): Int {
        return manager.getViewType(data[position])
    }

    fun add(item: Entrust<*, T>) = manager.add(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ViewBinding> {
        val viewHolder = ViewHolder(manager.getViewHolderByViewType(viewType).getViewBinding(LayoutInflater.from(context), parent))
        setListener(viewHolder)
        return viewHolder
    }

    private fun setListener(viewHolder: ViewHolder<ViewBinding>) {
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

    override fun onBindViewHolder(holder: ViewHolder<ViewBinding>, position: Int) {
        val t: T = data[position]
        manager.getViewHolderByItem(t).onBind(context, holder.binding, position, t)
    }

    override fun getItemCount(): Int = data.size
}