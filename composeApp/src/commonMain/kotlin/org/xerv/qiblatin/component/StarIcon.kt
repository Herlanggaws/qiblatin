package org.xerv.qiblatin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StarIcon(modifier: Modifier = Modifier, filled: Boolean = true, tint: Color) {
    // A simplified star implementation - replace with proper drawing logic if needed
    Box(
        modifier = modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(if (filled) tint else Color.Transparent)
            .padding(2.dp)
    ) {
        if (!filled) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .align(Alignment.Center)
            )
        }
    }
}