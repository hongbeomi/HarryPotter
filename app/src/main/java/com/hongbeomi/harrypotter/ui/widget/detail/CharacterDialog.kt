package com.hongbeomi.harrypotter.ui.widget.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.coil.rememberCoilPainter
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.widget.lottie.LoopLottieAnimation
import com.hongbeomi.harrypotter.model.Character
import com.hongbeomi.harrypotter.ui.HouseType
import com.hongbeomi.harrypotter.ui.widget.util.harryPotterFont

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

@Composable
fun CharacterDialog(
    character: Character,
    houseType: HouseType,
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.background),
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    width = 2.dp,
                    color = colorResource(id = houseType.color)
                ),
        ) {
            LoopLottieAnimation(
                rawId = R.raw.lightning,
                modifier = Modifier.matchParentSize()
            )
            CharacterDialogContent(
                character = character,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun CharacterDialogContent(
    character: Character,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier.fillMaxWidth()) {
        val (image, name, info) = createRefs()

        Image(
            painter = rememberCoilPainter(request = character.image),
            contentDescription = "character info",
            modifier = Modifier
                .constrainAs(image) {
                    linkTo(
                        start = parent.start,
                        top = parent.top,
                        end = name.start,
                        bottom = parent.bottom
                    )
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = character.name,
            modifier = Modifier.constrainAs(name) {
                linkTo(
                    start = image.end,
                    top = parent.top,
                    end = parent.end,
                    bottom = info.top,
                    startMargin = 16.dp
                )
                height = Dimension.wrapContent
                width = Dimension.fillToConstraints
            },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = harryPotterFont,
            color = colorResource(id = R.color.white)
        )
        Text(
            text = character.getInfoText(),
            modifier = Modifier.constrainAs(info) {
                linkTo(
                    start = name.start,
                    top = name.bottom,
                    end = parent.end,
                    bottom = parent.bottom
                )
                height = Dimension.wrapContent
                width = Dimension.fillToConstraints
            },
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            fontFamily = harryPotterFont,
            color = colorResource(id = R.color.white)
        )
    }
}

@Preview("character dialog")
@Composable
fun PreviewCharacterDialogContent() {
    CharacterDialogContent(
        character = Character(
            name = "potter",
            species = "harry potter",
            gender = "man",
            house = "house",
            dateOfBirth = "123",
            yearOfBirth = "123",
            ancestry = "test",
            patronus = "dog",
            actor = "name",
            alive = true,
            image = "http://hp-api.herokuapp.com/images/harry.jpg"
        )
    )
}