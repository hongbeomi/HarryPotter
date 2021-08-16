package github.hongbeomi.main

/**
 * Copyright 2020 Hongbeom Ahn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import github.hongbeomi.core_ui.HouseType
import github.hongbeomi.core_ui.HouseType.*
import github.hongbeomi.main.databinding.ItemHouseBinding

class HomeAdapter(val action: (ImageView, HouseType) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.MainViewHolder>() {

    private val items = mutableListOf(
        Gryffindor,
        Slytherin,
        Ravenclaw,
        Hufflepuff
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemHouseBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_house,
            parent,
            false
        ).let { MainViewHolder(it) }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(items[position])

    inner class MainViewHolder(private val binding: ItemHouseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                action(
                    binding.imageViewItemHouseLogo,
                    items[bindingAdapterPosition]
                )
            }
        }

        fun bind(item: HouseType) {
            binding.apply {
                house = item
                executePendingBindings()
            }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bind:transformer")
        fun bindAdapterTransform(view: DiscreteScrollView, isTransform: Boolean) {
            if (isTransform) {
                view.setItemTransformer(
                    ScaleTransformer.Builder()
                        .setMaxScale(1.25f)
                        .setMinScale(0.8f)
                        .build()
                )
            }
        }
    }

}