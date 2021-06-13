package com.hongbeomi.harrypotter.ui.widget.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.widget.util.harryPotterFont
import kotlin.math.absoluteValue

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
fun MainPager(
    list: List<HouseType>,
    modifier: Modifier = Modifier,
    onItemSelected: (HouseType) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = list.size)

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        itemSpacing = 16.dp
    ) { page ->
        val logo = list[page].logo
        val name = list[page].name
        Column(
            Modifier.clickable(
                true,
                onClick = { onItemSelected.invoke(list[page]) }
            ).graphicsLayer {
                val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                lerp(
                    start = ScaleFactor(0.55f, 0.55f),
                    stop = ScaleFactor(1f, 1f),
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale.scaleX
                    scaleY = scale.scaleY
                }

                alpha = lerp(
                    start = ScaleFactor(0.5f, 0.5f),
                    stop = ScaleFactor(1f, 1f),
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).scaleX
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = logo),
                contentDescription = "",
                modifier = Modifier.size(320.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = harryPotterFont,
                color = colorResource(id = R.color.white),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

    }
}

@ExperimentalPagerApi
@Preview("main pager")
@Composable
fun PreviewMainPager() {
    MainPager(
        list = listOf(
            HouseType.Gryffindor,
            HouseType.Slytherin,
            HouseType.Ravenclaw,
            HouseType.Hufflepuff
        ),
        onItemSelected = { },
        modifier = Modifier.fillMaxSize()
    )
}