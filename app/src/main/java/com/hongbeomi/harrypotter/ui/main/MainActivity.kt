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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.google.accompanist.pager.ExperimentalPagerApi
import com.hongbeomi.harrypotter.base.BaseActivity
import com.hongbeomi.harrypotter.ui.detail.DetailActivity
import com.hongbeomi.harrypotter.ui.widget.main.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen { type ->
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.KEY_HOUSE, type)
                startActivity(intent)
            }
        }
    }

}