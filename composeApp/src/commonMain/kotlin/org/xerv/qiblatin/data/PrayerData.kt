package org.xerv.qiblatin.data

@Serializable
data class PrayerData(
    val timings: PrayerTimings,
    val date: DateInfo
)