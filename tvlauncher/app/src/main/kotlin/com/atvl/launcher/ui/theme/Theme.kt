package com.atvl.launcher.ui.theme

import androidx.compose.runtime.Composable
import androidx.tv.material3.MaterialTheme as TVMaterialTheme
import androidx.tv.material3.darkColorScheme as tvDarkColorScheme

private val DarkColorScheme = tvDarkColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    onBackground = Purple80,
    secondary = Secondary,
    background = Background,
    surface = Surface,
    onSurface = OnSurface
)

@Composable
fun ATVLTheme(
    content: @Composable () -> Unit
) {
    TVMaterialTheme(
        colorScheme = DarkColorScheme,
        typography = androidx.tv.material3.Typography(
            bodyLarge = TextStyle(
                fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            ),
            titleLarge = TextStyle(
                fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp
            ),
            labelSmall = TextStyle(
                fontFamily = androidx.compose.ui.text.font.FontFamily.Default,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp
            )
        ),
        content = content
    )
}
