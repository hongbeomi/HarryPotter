package com.hongbeomi.harrypotter.ui.detail

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

    private var itemList = mutableListOf<Character>()

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

    fun updateList(list: List<Character>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    inner class DetailViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character) {
            binding.apply {
                character = item
                executePendingBindings()
                root.setOnClickListener {
                    MaterialDialog(root.context).show {
                        customView(
                            view = DataBindingUtil.inflate<DialogDetailBinding>(
                                LayoutInflater.from(root.context),
                                R.layout.dialog_detail,
                                null,
                                false
                            ).also {
                                it.character = binding.character
                                it.imageViewDialogDetailPhoto.clipToOutline = true
                            }.root
                        )
                        cornerRadius(root.context.resources.getDimension(R.dimen.dp_8))
                    }
                }
            }
        }

    }

}
