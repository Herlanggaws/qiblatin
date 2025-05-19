package org.xerv.qiblatin.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.xerv.qiblatin.presentation.LightGray
import org.xerv.qiblatin.presentation.PrimaryOrange

@Composable
fun WeeklySchedulePreview() {
    Column {
        Text(
            "Weekly Schedule",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Week days with prayer time variations
        val weekDays = listOf(
            Triple("Monday", "Fajr gets earlier", "+2 min"),
            Triple("Tuesday", "Consistent times", "±0 min"),
            Triple("Wednesday", "Maghrib gets later", "+1 min"),
            Triple("Thursday", "Consistent times", "±0 min"),
            Triple("Friday", "Prayer times shift", "±2 min")
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = LightGray),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                weekDays.forEach { (day, note, change) ->
                    WeekDayItem(day, note, change)
                    if (day != "Friday") {
                        Divider(
                            color = Color.Gray.copy(alpha = 0.3f),
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Download button
        Button(
            onClick = { /* Download calendar logic */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                "Download Full Calendar",
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}