package com.hongbeomi.harrypotter.ui.widget.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.hongbeomi.harrypotter.R
import com.hongbeomi.harrypotter.ui.HouseType

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
    ) { page ->
        val logo = list[page].logo
        val name = list[page].name
        Column(
            Modifier.clickable(true, onClick = { onItemSelected.invoke(list[page]) }),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painterResource(id = logo),
                contentDescription = "",
                Modifier
                    .height(320.dp)
                    .width(320.dp),
                contentScale = ContentScale.Fit,
            )
            Text(
                text = name,
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

@ExperimentalPagerApi
@Preview
@Composable
fun PreviewHomeRow() {
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