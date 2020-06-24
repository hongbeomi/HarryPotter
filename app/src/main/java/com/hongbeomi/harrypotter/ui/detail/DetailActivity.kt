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
import androidx.activity.viewModels
import androidx.core.app.ActivityOptionsCompat
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.base.BaseActivity
import com.hongbeomi.harrypotter.databinding.ActivityDetailBinding
import com.hongbeomi.harrypotter.ui.HouseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity() {

    companion object {
        const val KEY_HOUSE = "house"
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

    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)
    private val house by lazy { intent.getSerializableExtra(KEY_HOUSE) as HouseType }
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            house = this@DetailActivity.house
            lifecycleOwner = this@DetailActivity
            viewModel = this@DetailActivity.viewModel
        }
        viewModel.characterList.observe(::getLifecycle) {
            viewModel.loading.value = false
        }
    }

}