package com.hongbeomi.harrypotter.ui.widget.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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

@ExperimentalFoundationApi
@Composable
fun DetailScreen() {
    val lazyListState = rememberLazyListState()
    var scrollY = 0f
    var previousOffset = 0

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .graphicsLayer {
                    scrollY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                    println(lazyListState.firstVisibleItemScrollOffset.toString())
                    translationY = scrollY * 0.5f
                    previousOffset = lazyListState.firstVisibleItemScrollOffset
                }
                .fillMaxWidth()
                .height(240.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_gryffindor),
                contentDescription = "",
                modifier = Modifier.fillMaxHeight(),
                alignment = Alignment.CenterEnd
            )
            Text(
                text = "test",
                fontFamily = FontFamily(
                    Font(R.font.harry_potter)
                ),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp
            )
        }
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 3),
            modifier = Modifier.fillMaxSize(),
            state = lazyListState,
            contentPadding = PaddingValues(2.dp),
        ) {
            items(100) {
                Text(text = it.toString())
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun PreviewDetailScreen() {
    DetailScreen()
}