package com.hongbeomi.harrypotter.ui.widget.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.widget.lottie.LoopLottieAnimation

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

@ExperimentalPagerApi
@Composable
fun MainScreen(onItemSelected: (HouseType) -> Unit) {
    val itemList = remember {
        listOf(
            HouseType.Gryffindor,
            HouseType.Slytherin,
            HouseType.Ravenclaw,
            HouseType.Hufflepuff
        )
    }
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        LoopLottieAnimation(rawId = R.raw.lightning)

        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(128.dp))
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(288.dp)
                    .height(120.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))
            MainPager(
                list = itemList,
                onItemSelected = onItemSelected,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@ExperimentalPagerApi
@Preview("main screen")
@Composable
fun PreviewMainScreen() {
    MainScreen { }
}