package com.atvl.launcher.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.atvl.launcher.data.AppInfo
import com.atvl.launcher.ui.components.focusScale

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppCard(
    app: AppInfo,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(120.dp)
            .padding(8.dp)
            .focusScale()
    ) {
        Card(
            onClick = onClick,
            scale = CardDefaults.scale(focusedScale = 1.0f),
            border = CardDefaults.border(
                focusedBorder = BorderStroke(2.dp, Color.White)
            ),
            modifier = Modifier.size(100.dp)
        ) {
            AsyncImage(
                model = app.icon,
                contentDescription = app.label,
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(
            text = app.label,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 4.dp),
            color = Color.White
        )
    }
}
