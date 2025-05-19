package org.xerv.qiblatin.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.xerv.qiblatin.presentation.MintGreen
import org.xerv.qiblatin.presentation.PrimaryOrange

@Composable
fun PrayerTimeItem(prayer: String, time: String, status: String) {
    val statusColor = when(status) {
        "Missed" -> Color.Red
        "Prayed" -> MintGreen
        "Next" -> PrimaryOrange
        else -> Color.Gray
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                prayer,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                time,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Text(
            status,
            fontSize = 16.sp,
            color = statusColor,
            fontWeight = FontWeight.Medium
        )
    }
}