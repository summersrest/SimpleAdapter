package com.sum.adaptersample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sum.adaptersample.databinding.ActivitySampleBinding
import com.sum.adaptersample.databinding.ItemLeftBinding
import com.sum.sampleadapter.SimpleAdapter
import com.sum.sampleadapter.SimpleMultipleAdapter
import com.sum.sampleadapter.multiple.Entrust

/**
 * @author  LiuJiang
 * created  at: 2024/8/28 16:26
 * Desc:
 */
class SampleActivity: AppCompatActivity() {
    private lateinit var viewBinding: ActivitySampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySampleBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        val data = listOf("变形金刚", "泰坦尼克号", "X战警", "巨齿鲨", "流浪地球", "奥本海默", "拯救大兵瑞恩", "星际大战")
        val adapter = SimpleMultipleAdapter(this, data)
        adapter.add(LeftEntrust())
        adapter.add(RightEntrust())
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewBinding.recyclerView.adapter = adapter
    }
}

class MyAdapter(context: Context, data: List<String>): SimpleAdapter<ItemLeftBinding, String>(context, data) {
    override fun getViewBinding(viewType: Int, layoutInflater: LayoutInflater, parent: ViewGroup): ItemLeftBinding {
        return ItemLeftBinding.inflate(layoutInflater, parent, false)
    }

    override fun onBind(context: Context, binding: ItemLeftBinding, position: Int, item: String) {
        binding.tvText.text = item
    }

}