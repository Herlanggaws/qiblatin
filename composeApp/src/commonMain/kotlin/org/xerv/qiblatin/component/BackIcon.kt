package org.xerv.qiblatin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BackIcon() {
    Box(modifier = Modifier.size(24.dp)) {
        // Horizontal line for arrow
        Box(
            modifier = Modifier
                .width(12.dp)
                .height(2.dp)
                .background(Color.DarkGray)
                .align(Alignment.Center)
        )

        // Arrow head (left side)
        Box(
            modifier = Modifier
                .width(8.dp)
                .height(8.dp)
                .align(Alignment.CenterStart)
        ) {
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(6.dp)
                    .background(Color.DarkGray)
                    .rotate(45f)
                    .align(Alignment.BottomStart)
            )

            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(6.dp)
                    .background(Color.DarkGray)
                    .rotate(-45f)
                    .align(Alignment.TopStart)
            )
        }
    }
}