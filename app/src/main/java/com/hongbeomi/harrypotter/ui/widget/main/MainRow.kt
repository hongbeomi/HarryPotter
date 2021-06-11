package com.hongbeomi.harrypotter.ui.widget.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.max

@Composable
fun MainRow(
    list: List<HouseType>,
    onItemSelected: (HouseType) -> Unit
) {
    val state: LazyListState = rememberLazyListState()
    LazyRow(
        state = state,
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
    ) {
        items(
            items = list,
            key = { it.name }
        ) {
            Column(
                Modifier
                    .clickable(
                        true,
                        onClick = { onItemSelected.invoke(it) }
                    )
                    .graphicsLayer {
                        val value = state.layoutInfo.normalizedItemPosition(it.name)
                        scaleX = value
                        scaleY = value
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painterResource(id = it.logo),
                    contentDescription = "",
                    Modifier
                        .height(320.dp)
                        .width(320.dp),
                    contentScale = ContentScale.Fit,

                    )
                Text(
                    text = it.name,
                    fontSize = 24.sp,
                    fontFamily = FontFamily(
                        Font(R.font.harry_potter)
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeRow() {
    MainRow(
        list = listOf(
            HouseType.Gryffindor,
            HouseType.Slytherin,
            HouseType.Ravenclaw,
            HouseType.Hufflepuff
        ),
        onItemSelected = { }
    )
}

fun LazyListLayoutInfo.normalizedItemPosition(key: Any): Float {
    val value = visibleItemsInfo
        .firstOrNull { it.key == key }
        ?.let {
            val center = (viewportEndOffset + viewportStartOffset - it.size) / 2F
            (it.offset.toFloat() - center) / center
        } ?: 0F
    return max(0.3f, abs(1 - (value.absoluteValue * 0.15f)))
}