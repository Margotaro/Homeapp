package com.example.homeapp.ui

import android.content.res.Resources.Theme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.homeapp.data.allWords
import com.example.homeapp.model.BookPage
import com.example.homeapp.R
import com.example.homeapp.ui.theme.Typography
import com.example.homeapp.ui.theme.TypographyMetropolis
import kotlin.text.Typography

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier
    .fillMaxSize()
    .background(Color(255, 244, 243)),
    bookPreviewViewModel: BookPreviewViewModel = viewModel()
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(55.dp))
        SetUpPager()
        Spacer(modifier = Modifier.height(100.dp))
        SetDifficultyBar()
        SetBookDescription()
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(40.dp)
                .width(157.dp),
            shape = CutCornerShape(30),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(255, 131, 131))
        ) {
            Text(
                text = stringResource(R.string.start_uppercase),
                style = TypographyMetropolis.subtitle2
            )
        }
    }
}

@Composable
fun SetUpPager(items : List<BookPage> = allWords) {
    Pager(
        items = items,
        modifier = Modifier
            .fillMaxWidth()
            .height(256.dp),
        itemFraction = .75f,
        overshootFraction = .75f,
        initialIndex = 0,
        itemSpacing = 16.dp,
        contentFactory = { item ->
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.book_cover_pink),
                    contentDescription = "background_image",
                    modifier = Modifier.fillMaxSize())
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = stringResource(R.string.learn),
                        style = Typography.subtitle1,
                    )
                    Text(
                        text = item.book.name,
                        style = Typography.h1,
                    )
                }
            }
        }
    )
}

@Composable
fun SetBookDescription(text: String = "Explore the exciting natural world around us.\n" +
        "This is your very own nature scrapbook, packed with fascinating " +
        "facts and brilliant activities. Doodle, draw and colour and find " +
        "out how plants grow as well as the different parts of plants, seeds, " +
        "and flowers.") {
    Spacer(modifier = Modifier.height(22.dp))
    Text(
        text = text,
        modifier = Modifier.width(272.dp),
        textAlign = TextAlign.Center,
        style = Typography.body1
    )
}

@Composable
fun SetDifficultyBar() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.height(11.dp))
        Text(
            text = stringResource(R.string.difficulty),
            modifier = Modifier.padding(end = 9.dp),
            style = TypographyMetropolis.body1
        )
        LinearProgressIndicator(
            progress = 0.7f,
            modifier= Modifier
                .width(92.dp)
                .border(border = BorderStroke(1.dp, MaterialTheme.colors.onSecondary)),
            backgroundColor = Color.Unspecified,
            color = MaterialTheme.colors.onSecondary
        )
    }
}
