package com.hongbeomi.harrypotter.base

import android.os.Parcelable
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hongbeomi.harrypotter.ui.HouseType

abstract class BaseViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
    
    abstract fun bind(item: Any)
    
}
