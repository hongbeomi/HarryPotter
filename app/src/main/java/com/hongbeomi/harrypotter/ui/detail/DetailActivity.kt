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

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.base.BaseActivity
import com.hongbeomi.harrypotter.databinding.ActivityDetailBinding
import com.hongbeomi.harrypotter.model.Character
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.SpaceItemDecoration
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : BaseActivity() {

    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)

    private val houseType by lazy { intent.getSerializableExtra(KEY_HOUSE) as HouseType }
    private val viewModel: DetailViewModel by viewModel { parametersOf(houseType) }
    private val detailAdapter by lazy {  DetailAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@DetailActivity
            house = houseType
            vm = viewModel

            bindList(viewModel.characterList)
            bindImage(houseType.logo)
        }
    }

    private fun ActivityDetailBinding.bindList(
        characterList: LiveData<List<Character>>
    ) {
        with(recyclerViewDetail) {
            this.adapter = detailAdapter
            setBackgroundColor(
                ContextCompat.getColor(context, this@DetailActivity.houseType.color)
            )
            addItemDecoration(
                SpaceItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.dp_2), 3
                )
            )
        }
        characterList.observe(this@DetailActivity) {
            detailAdapter.submitList(it)
        }
    }

    private fun ActivityDetailBinding.bindImage(
        @DrawableRes
        imageResId: Int
    ) {
        imageViewDetail.setImageResource(imageResId)
    }

    companion object {
        private const val KEY_HOUSE = "house"

        fun startActivityWithTransition(
            activity: Activity,
            imageView: ImageView,
            type: HouseType
        ) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(KEY_HOUSE, type)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, imageView, imageView.transitionName
            )
            activity.startActivity(intent, options.toBundle())
        }
    }

}