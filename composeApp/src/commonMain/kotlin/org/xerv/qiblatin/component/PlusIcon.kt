package org.xerv.qiblatin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlusIcon(modifier: Modifier = Modifier, tint: Color = Color.White) {
    Box(modifier = modifier) {
        // Horizontal line
        Box(modifier = Modifier
            .width(16.dp)
            .height(2.dp)
            .background(tint)
            .align(Alignment.Center))

        // Vertical line
        Box(modifier = Modifier
            .width(2.dp)
            .height(16.dp)
            .background(tint)
            .align(Alignment.Center))
    }
}