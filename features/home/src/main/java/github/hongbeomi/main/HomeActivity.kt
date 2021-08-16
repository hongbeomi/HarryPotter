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

import android.os.Bundle
import github.hongbeomi.core_ui.BaseActivity
import github.hongbeomi.detail.DetailActivity.Companion.startActivityWithTransition
import github.hongbeomi.main.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@HomeActivity
            adapter = HomeAdapter { view, type ->
                startActivityWithTransition(this@HomeActivity, view, type)
            }
        }
    }

}