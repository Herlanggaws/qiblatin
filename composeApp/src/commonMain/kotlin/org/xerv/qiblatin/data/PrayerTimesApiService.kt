package org.xerv.qiblatin.data

import org.xerv.qiblatin.data.response.PrayerResponseDto

interface PrayerTimesApiService {
    suspend fun getPrayerTimes(
        city: String,
        country: String,
        date: String,
        method: Int
    ): PrayerResponseDto
}