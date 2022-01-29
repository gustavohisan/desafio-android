package com.picpay.desafio.design

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val typography = Typography(
    h1 = TextStyle(
        color = white,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    body1 = TextStyle(
        color = white,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        color = colorDetail,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
