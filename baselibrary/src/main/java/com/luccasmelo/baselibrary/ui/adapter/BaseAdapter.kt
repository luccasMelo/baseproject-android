package com.luccasmelo.baselibrary.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>() : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder,
        position: Int
    ) {
        val obj = getObjForPosition(position)
        holder.bind(obj, getVar())
    }

    protected abstract fun getVar(): Int

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): Any

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    protected abstract fun update(objects: List<T>)
}

class BaseViewHolder internal constructor(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(anyModel: Any, variable: Int) {
        binding.setVariable(variable, anyModel)
        binding.executePendingBindings()
    }
}

class BaseModel(val position: Int, val item: Any) {
    var aux: Any? = null

}