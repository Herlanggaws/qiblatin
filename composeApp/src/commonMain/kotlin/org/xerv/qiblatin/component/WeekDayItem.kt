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
fun WeekDayItem(day: String, note: String, change: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                day,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                note,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Text(
            change,
            fontSize = 16.sp,
            color = if (change.contains("+")) PrimaryOrange else MintGreen,
            fontWeight = FontWeight.Medium
        )
    }
}