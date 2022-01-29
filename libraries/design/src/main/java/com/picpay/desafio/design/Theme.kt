package com.picpay.desafio.design

import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val ColorPalette = lightColors(
    primary = colorAccent,
    background = primaryDark
)

@Composable
fun ApplicationTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = ColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
