package com.example.homeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.homeapp.R

private val mainFont = FontFamily(
    Font(R.font.abhaya_libre_regular, FontWeight.Normal),
    Font(R.font.abhaya_libre_bold, FontWeight.Bold),
    Font(R.font.abhaya_libre_medium, FontWeight.Medium),
    Font(R.font.abhaya_libre_semibold, FontWeight.SemiBold),
    Font(R.font.abhaya_libre_extrabold, FontWeight.ExtraBold),
)

private val metropolisFont = FontFamily(
    Font(R.font.metropolis_medium, FontWeight.Medium),
    Font(R.font.metropolis_light, FontWeight.Light),
    Font(R.font.metropolis_thin, FontWeight.Thin),
    Font(R.font.metropolis_regular, FontWeight.Normal),
    Font(R.font.metropolis_semibold, FontWeight.SemiBold),
)


val Typography = Typography(
    defaultFontFamily = mainFont,
    h1 = TextStyle(
        fontFamily = mainFont,
        fontWeight = FontWeight(700),
        fontSize = 40.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = mainFont,
        fontWeight = FontWeight(700),
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = mainFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)

val TypographyMetropolis = Typography(
    defaultFontFamily = metropolisFont,
    h1 = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight(700),
        fontSize = 40.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight(500),
        fontSize = 14.sp,
        letterSpacing = 0.07.sp,
    ),
    subtitle2 = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight(600),
        fontSize = 14.sp,
        letterSpacing = 0.05.sp,
    ),
    body1 = TextStyle(
        fontFamily = metropolisFont,
        fontWeight = FontWeight(500),
        fontSize = 12.sp
    ),
)