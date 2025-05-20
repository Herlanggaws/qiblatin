package org.xerv.qiblatin.presentation.prayerschedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.koinInject
import org.xerv.qiblatin.component.BackIcon
import org.xerv.qiblatin.component.DateSelector
import org.xerv.qiblatin.component.DailyPrayerSchedule
import org.xerv.qiblatin.component.WeeklySchedulePreview
import org.xerv.qiblatin.presentation.LightGray


@Composable
fun PrayerScheduleScreen(
    onBackClick: () -> Unit,
    viewModel: PrayerScheduleViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header with back button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(LightGray)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    BackIcon()
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Prayer Schedule",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Date picker
            DateSelector(
                selectedDate = uiState.selectedDate,
                onDateChanged = viewModel::onDateChanged
            )

            Spacer(modifier = Modifier.height(16.dp))

            when {
                uiState.isLoading -> {
                    Text("Loading prayer times...")
                }
                uiState.error != null -> {
                    Text("Error: ${uiState.error}")

                }
                else -> {
                    // Prayer times
                    uiState.prayerResponse?.let {
                        DailyPrayerSchedule(it)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    WeeklySchedulePreview()
                }
            }
        }
    }
}