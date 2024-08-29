package com.sum.adaptersample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sum.adaptersample.databinding.ItemLeftBinding
import com.sum.adaptersample.databinding.ItemRightBinding
import com.sum.sampleadapter.multiple.Entrust

/**
 * @author  LiuJiang
 * created  at: 2024/8/28 16:33
 * Desc:
 */
class RightEntrust: Entrust<ItemRightBinding, String>() {
    override fun getViewBinding(layoutInflater: LayoutInflater, parent: ViewGroup): ItemRightBinding {
        return ItemRightBinding.inflate(layoutInflater, parent, false)
    }

    override fun isThisType(t: String): Boolean {
        return t.length > 4
    }

    override fun onBind(context: Context, binding: ItemRightBinding, position: Int, item: String) {
        binding.tvText.text = "${item}：我在右边"
    }

}