package org.xerv.qiblatin

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.xerv.qiblatin.presentation.HomeScreen
import org.xerv.qiblatin.presentation.nearbyplaces.NearbyPlacesScreen
import org.xerv.qiblatin.presentation.prayerschedule.PrayerScheduleScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

        when (currentScreen) {
            Screen.Home -> {
                HomeScreen(
                    onNavigateToSchedule = { currentScreen = Screen.PrayerSchedule },
                    onNavigateToNearbyPlaces = { currentScreen = Screen.NearbyPrayerPlaces }
                )
            }

            Screen.PrayerSchedule -> {
                PrayerScheduleScreen(
                    onBackClick = { currentScreen = Screen.Home }
                )
            }

            Screen.NearbyPrayerPlaces -> {
                NearbyPlacesScreen(
                    onBackClick = { currentScreen = Screen.Home }
                )
            }
        }
    }
}