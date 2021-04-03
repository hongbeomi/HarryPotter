package com.hongbeomi.harrypotter.ui.detail

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
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.databinding.DialogDetailBinding
import com.hongbeomi.harrypotter.databinding.ItemCharacterBinding
import com.hongbeomi.harrypotter.model.Character

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    var itemList = listOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ItemCharacterBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_character,
            parent,
            false
        ).let {
            it.constraintLayoutItemArea.layoutParams.height = (parent.width / 3) * 2
            DetailViewHolder(it)
        }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) =
        holder.bind(itemList[position])

    inner class DetailViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                MaterialDialog(binding.root.context).show {
                    customView(
                            view = DataBindingUtil.inflate<DialogDetailBinding>(
                                    LayoutInflater.from(binding.root.context),
                                    R.layout.dialog_detail,
                                    null,
                                    false
                            ).also {
                                it.character = binding.character
                                it.imageViewDialogDetailPhoto.clipToOutline = true
                            }.root
                    )
                    cornerRadius(binding.root.context.resources.getDimension(R.dimen.dp_8))
                }
            }
        }

        fun bind(item: Character) {
            binding.apply {
                character = item
                executePendingBindings()
            }
        }

    }

}
