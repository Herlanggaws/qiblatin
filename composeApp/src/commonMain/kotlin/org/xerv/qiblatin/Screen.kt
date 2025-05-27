package org.xerv.qiblatin

sealed class Screen {
    object Home : Screen()
    object PrayerSchedule : Screen()
    object NearbyPrayerPlaces : Screen()
}