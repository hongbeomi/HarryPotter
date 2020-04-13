package com.hongbeomi.harrypotter.ui.main

import android.os.Bundle
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.base.BaseActivity
import com.hongbeomi.harrypotter.databinding.ActivityMainBinding
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.detail.DetailActivity.Companion.startActivityWithTransition

class MainActivity : BaseActivity() {

    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            adapter = MainAdapter { view, type ->
                startActivityWithTransition(this@MainActivity, view, type)
            }
        }
    }

}