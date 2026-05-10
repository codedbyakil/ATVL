package com.atvl.launcher.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.tv.material3.MaterialTheme as TvMaterialTheme
import androidx.tv.material3.darkColorScheme as tvDarkColorScheme

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Background,
    surface = Surface,
    onSurface = OnSurface
)

private val TvDarkColorScheme = tvDarkColorScheme(
    primary = Primary,
    background = Background,
    surface = Surface,
    onSurface = OnSurface
)

@Composable
fun ATVLTheme(
    content: @Composable () -> Unit
) {
    TvMaterialTheme(
        colorScheme = TvDarkColorScheme,
        typography = androidx.tv.material3.Typography(),
        content = content
    )
}
