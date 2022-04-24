package com.hongbeomi.harrypotter.ui.main

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

import android.os.Bundle
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.base.BaseActivity
import com.hongbeomi.harrypotter.databinding.ActivityMainBinding
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.detail.DetailActivity.Companion.startActivityWithTransition
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            lifecycleOwner = this@MainActivity
            bindDiscreteScroll()
        }
    }

    private fun ActivityMainBinding.bindDiscreteScroll() {
        with(scrollViewMainList) {
            adapter = MainAdapter { view, type ->
                startActivityWithTransition(this@MainActivity, view, type)
            }
            setItemTransformer(
                ScaleTransformer.Builder()
                    .setMaxScale(1.25f)
                    .setMinScale(0.8f)
                    .build()
            )
        }
    }

}