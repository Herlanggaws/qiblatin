package org.xerv.qiblatin.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.xerv.qiblatin.component.NextPrayerCard
import org.xerv.qiblatin.component.RecentActivityCard
import org.xerv.qiblatin.component.StreakCard
import org.xerv.qiblatin.component.NearbyPrayerPlaces
import org.xerv.qiblatin.component.PlusIcon

val PrimaryOrange = Color(0xFFEF8354)
val LightGray = Color(0xFFF5F5F5)
val MintGreen = Color(0xFF6BBDA3)

@Composable
fun HomeScreen(
    onNavigateToSchedule: () -> Unit,
    onNavigateToNearbyPlaces: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NextPrayerCard(onViewScheduleClick = onNavigateToSchedule)
            Spacer(modifier = Modifier.height(24.dp))
            NearbyPrayerPlaces(onViewNearbyClick = onNavigateToNearbyPlaces)
            Spacer(modifier = Modifier.height(24.dp))
            RecentActivityCard()
            Spacer(modifier = Modifier.height(24.dp))
            StreakCard()
        }

        // Floating action buttons at the bottom right
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            FloatingActionButton(
                onClick = { /* Add new location logic */ },
                modifier = Modifier.size(56.dp),
                containerColor = MintGreen,
                contentColor = Color.White
            ) {
                PlusIcon()
            }

            Button(
                onClick = { /* Check-in logic */ },
                modifier = Modifier.height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Check-in Here", color = Color.White)
            }

            Button(
                onClick = { /* Add new location logic */ },
                modifier = Modifier.height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MintGreen),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Add New Location", color = Color.White)
            }
        }
    }
}