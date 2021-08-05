package com.sum.simple.multiple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sum.simple.base.ViewHolder;
import com.sum.simple.interfaces.OnItemClickListener;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * @author liujiang
 * created at: 2021/8/5 15:50
 * Desc:
 */
public class MultipleAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context context;
    protected List<T> datas;
    protected EntrustManager<T> manager;
    protected OnItemClickListener<T> onClickListener;


    public MultipleAdapter(Context context, List<T> datas) {
        this.context = context;
        this.datas = datas;
        manager = new EntrustManager<>();
    }


    @Override
    public int getItemViewType(int position) {
        return manager.getViewTypeByPosition(datas.get(position));
    }

    public void add(Entrust item) {
        manager.add(item);
    }

    @NonNull
    @Override
    public ViewHolder<ViewBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder<ViewBinding> viewHolder = new ViewHolder<>(manager.getByViewType(viewType).getViewBinding(LayoutInflater.from(context), parent));
        setListener(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        T t = datas.get(position);
        manager.getByItem(t).onBind(context, holder, t, position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    protected void setListener(final ViewHolder viewHolder) {
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
    }

    public void setOnclickListener(OnItemClickListener<T> onClickListener) {
        this.onClickListener = onClickListener;
    }
}
