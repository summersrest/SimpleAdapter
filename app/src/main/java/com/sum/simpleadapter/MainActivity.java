package com.sum.simpleadapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sum.simple.BaseAdapter;
import com.sum.simple.base.ViewHolder;
import com.sum.simple.interfaces.SimpleOnItemClickListener;
import com.sum.simple.multiple.MultipleAdapter;
import com.sum.simpleadapter.databinding.ActivityMainBinding;
import com.sum.simpleadapter.databinding.ItemMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View rootView = viewBinding.getRoot();
        setContentView(rootView);

        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        viewBinding.recyclerView.setLayoutManager(linearLayoutManager);

        List<String> list = Arrays.asList("变形金刚", "X战警", "复仇者联盟", "阿凡达", "战狼", "拯救大兵瑞恩", "肖申克的救赎", "阿甘正传", "泰坦尼克号", "蝙蝠侠", "雷神");
        List<ItemBean> datas = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            datas.add(new ItemBean(list.get(i), i % 2));
        }

//        BaseAdapter<ItemMainBinding, ItemBean> adapter = new BaseAdapter<ItemMainBinding, ItemBean>(this, datas) {
//            @Override
//            protected ItemMainBinding getViewBinding(int viewType, LayoutInflater layoutInflater, ViewGroup parent) {
//                    return ItemMainBinding.inflate(layoutInflater, parent, false);
//            }
//
//            @Override
//            protected void onBind(Context context, ViewHolder<ItemMainBinding> holder, ItemBean item, int position) {
//                holder.binding.tvText.setText(item.getTitie());
//            }
//
//        };
//
//        viewBinding.recyclerView.setAdapter(new BaseAdapter<ItemMainBinding, String>(this, list) {
//
//            @Override
//            protected ItemMainBinding getViewBinding(int viewType, LayoutInflater layoutInflater, ViewGroup parent) {
//                return ItemMainBinding.inflate(layoutInflater, parent, false);
//            }
//
//            @Override
//            protected void onBind(Context context, ViewHolder<ItemMainBinding> holder, String item, int position) {
//                holder.binding.tvText.setText(item);
//            }
//        });
//
//        adapter.setOnclickListener(new SimpleOnItemClickListener<ItemBean>() {
//            @Override
//            public void onItemClick(View view, ItemBean item, int position) {
//                Toast.makeText(MainActivity.this, item.getTitie(), Toast.LENGTH_SHORT).show();
//            }
//        });

        MultipleAdapter<ItemBean> multipleAdapter = new MultipleAdapter<>(this, datas);
        multipleAdapter.add(new LeftEntrust());
        multipleAdapter.add(new RightEntrust());
        viewBinding.recyclerView.setAdapter(multipleAdapter);
        multipleAdapter.setOnclickListener(new SimpleOnItemClickListener<ItemBean>() {
            @Override
            public void onItemClick(View view, ItemBean item, int position) {
                Toast.makeText(MainActivity.this, item.getTitie(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}