package com.hongbeomi.harrypotter.di

import com.hongbeomi.harrypotter.ui.detail.DetailViewModel
import com.hongbeomi.harrypotter.ui.HouseType
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (type: HouseType) -> DetailViewModel(type, repository = get()) }
}