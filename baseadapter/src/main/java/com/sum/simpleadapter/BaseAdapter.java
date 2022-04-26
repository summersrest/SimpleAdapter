package com.sum.simpleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sum.simpleadapter.base.ViewHolder;
import com.sum.simpleadapter.interfaces.OnItemClickListener;
import com.sum.simpleadapter.interfaces.OnItemFocusChangeListener;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * created at: 2021/8/5 9:40
 * Desc:
 */
public abstract class BaseAdapter<V extends ViewBinding, T> extends RecyclerView.Adapter<ViewHolder<V>> {
    protected Context context;
    protected List<T> datas;
    protected List<View> viewList = new ArrayList<>();
    protected OnItemClickListener<T> onClickListener;
    protected boolean isRecordLastFocusItem;
    private int recordPosition;
    /**
     * 获取viewBinding
     *
     * @param viewType
     * @param layoutInflater
     * @param parent
     * @return
     */
    protected abstract V getViewBinding(int viewType, LayoutInflater layoutInflater, ViewGroup parent);

    /**
     * 绑定控件
     *
     * @param context
     * @param holder
     * @param item
     * @param position
     */
    protected abstract void onBind(Context context, ViewHolder<V> holder, T item, int position);


    public BaseAdapter(Context context, List<T> datas) {
        this.datas = datas;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder<V> viewHolder = new ViewHolder<>(getViewBinding(viewType, LayoutInflater.from(context), parent));
        setListener(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<V> holder, int position) {
        onBind(context, holder, datas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    protected void setListener(final ViewHolder<V> viewHolder) {
        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onClickListener) {
                    int position = viewHolder.getAdapterPosition();
                    onClickListener.onItemClick(v, datas.get(position), position);
                }
            }
        });

        viewHolder.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (null != onClickListener) {
                    int position = viewHolder.getAdapterPosition();
                    return onClickListener.onItemLongClick(v, datas.get(position), position);
                }
                return false;
            }
        });
        //是否记录最后选中的item
        if (isRecordLastFocusItem) {
            viewList.add(viewHolder.binding.getRoot());
            viewHolder.binding.getRoot().setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        if (viewList.size() > recordPosition) {
                            viewList.get(recordPosition).setSelected(false);
                        }
                        recordPosition = viewHolder.getAdapterPosition();
                        viewHolder.binding.getRoot().setSelected(true);
                    }
                }
            });
        }




    }


    public void setOnItemClickListener(OnItemClickListener<T> onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void recordLastFocusItem(boolean isRecordLastFocusItem) {
        this.isRecordLastFocusItem = isRecordLastFocusItem;
    }

    public int getLastRecordPosition() {
        return recordPosition;
    }
}
