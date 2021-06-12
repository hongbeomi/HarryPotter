package com.hongbeomi.harrypotter.ui.widget.detail

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.google.accompanist.coil.rememberCoilPainter
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.model.Character
import com.hongbeomi.harrypotter.ui.widget.util.EnterAlphaAnimation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

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
fun CharacterList(
    characterFlow: Flow<List<Character>>,
    modifier: Modifier = Modifier,
    onClickItem: (Character) -> Unit = {}
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val characterFlowLifecycleAware = remember(characterFlow, lifecycleOwner) {
        characterFlow.flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.STARTED)
    }
    val characterList by characterFlowLifecycleAware.collectAsState(initial = listOf())

    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
    ) {
        items(characterList) {
            CharacterItem(
                character = it,
                modifier = Modifier.height(240.dp),
                onClick = onClickItem
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier,
    onClick: (Character) -> Unit = {}
) {
    Surface(
        modifier = modifier.padding(PaddingValues(2.dp)),
        color = colorResource(id = R.color.transparent),
    ) {
        ConstraintLayout(
            modifier = modifier
                .clip(RoundedCornerShape(4.dp))
                .background(color = colorResource(id = R.color.background))
                .clickable { onClick.invoke(character) }
        ) {
            val (image, name) = createRefs()
            Image(
                modifier = Modifier
                    .constrainAs(image) {
                        linkTo(
                            start = parent.start,
                            top = parent.top,
                            end = parent.end,
                            bottom = name.top
                        )
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
                painter = rememberCoilPainter(
                    request = character.image,
                    fadeIn = true
                ),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Text(
                modifier = Modifier
                    .constrainAs(name) {
                        linkTo(
                            start = parent.start,
                            end = parent.end,
                            top = image.bottom,
                            bottom = parent.bottom
                        )
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    },
                text = character.name,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.girassol_regular))
            )
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview("character list")
@Composable
fun PreviewCharacterList() {
    CharacterList(characterFlow = emptyFlow())
}
