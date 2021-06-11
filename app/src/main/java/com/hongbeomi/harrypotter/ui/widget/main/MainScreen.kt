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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType

@ExperimentalPagerApi
@Composable
fun MainScreen() {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.lightning) }
    val animationState = rememberLottieAnimationState(autoPlay = true, repeatCount = Int.MAX_VALUE)
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
            .background(Color.Black)
            .fillMaxSize()
    ) {
        LottieAnimation(
            spec = animationSpec,
            animationState = animationState
        )
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
                onItemSelected = {
                    // TODO: 2021/06/11 go to detail
                },
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
            )
        }
    }
}

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}