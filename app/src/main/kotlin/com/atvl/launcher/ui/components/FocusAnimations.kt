
package com.atvl.launcher.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun Modifier.focusScale(
    scale: Float = 1.05f,
    durationMillis: Int = 140
): Modifier = composed {
    var isFocused by remember { mutableStateOf(false) }
    val animatedScale by animateFloatAsState(
        targetValue = if (isFocused) scale else 1.0f,
        animationSpec = tween(durationMillis),
        label = "focusScale"
    )
    
    this
        .onFocusChanged { isFocused = it.isFocused }
        .scale(animatedScale)
}
