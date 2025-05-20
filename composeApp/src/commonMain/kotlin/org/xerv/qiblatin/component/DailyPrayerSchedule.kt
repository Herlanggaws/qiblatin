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
import org.xerv.qiblatin.domain.models.PrayerResponse
import org.xerv.qiblatin.presentation.LightGray

@Composable
fun DailyPrayerSchedule(prayerResponse: PrayerResponse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = LightGray),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Today's Schedule",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            val prayerTimes = listOf(
                Triple("Fajr", prayerResponse.data.timings.fajr, "Missed"),
                Triple("Dhuhr", prayerResponse.data.timings.dhuhr, "Prayed"),
                Triple("Asr", prayerResponse.data.timings.asr, "Prayed"),
                Triple("Maghrib", prayerResponse.data.timings.maghrib, "Next"),
                Triple("Isha", prayerResponse.data.timings.isha, "Upcoming")
            )

            prayerTimes.forEach { (prayer, time, status) ->
                PrayerTimeItem(prayer, time, status)
                if (prayer != "Isha") {
                    Divider(
                        color = Color.Gray.copy(alpha = 0.3f),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}
