package com.hongbeomi.harrypotter.ui.widget.util

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

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
@Composable
fun EnterAlphaAnimation(
    modifier: Modifier = Modifier,
    duration: Int = 4000,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    val visible = remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = visible.value,
        enter = fadeIn(animationSpec = tween(duration)),
        modifier = modifier,
        content = content
    )

    LaunchedEffect(key1 = visible) {
        visible.value = true
    }
}