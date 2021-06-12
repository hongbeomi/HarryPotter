package com.hongbeomi.harrypotter.ui.widget.detail

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.detail.DetailViewModel
import com.hongbeomi.harrypotter.ui.widget.lottie.LoopLottieAnimation
import com.hongbeomi.harrypotter.ui.widget.util.harryPotterFont
import com.hongbeomi.harrypotter.ui.widget.util.EnterAlphaAnimation
import com.hongbeomi.harrypotter.util.getLifecycleAwareState

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

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun DetailScreen(
    houseType: HouseType,
    viewModel: DetailViewModel = viewModel()
) {
    val isLoadingState by getLifecycleAwareState(
        flow = viewModel.isLoadingFlow,
        initialValue = false,
    )
    val characterDialog by getLifecycleAwareState(
        flow = viewModel.characterDialog,
        initialValue = null
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = houseType.color))
    ) {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.background)
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            EnterAlphaAnimation {
                Image(
                    painter = painterResource(id = houseType.logo),
                    contentDescription = "",
                    modifier = Modifier.size(32.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            EnterAlphaAnimation {
                Text(
                    text = houseType.name,
                    fontFamily = harryPotterFont,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
        if (isLoadingState) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LoopLottieAnimation(rawId = R.raw.wingardium_leviosa)
            }
        } else {
            CharacterList(
                characterFlow = viewModel.characterListFlow,
                modifier = Modifier.fillMaxSize(),
                onClickItem = { viewModel.showCharacterDialogEvent(it) }
            )
        }
    }

    characterDialog?.let {
        CharacterDialog(
            character = it,
            houseType = houseType
        ) {
            viewModel.hideCharacterDialogEvent()
        }
    }
}