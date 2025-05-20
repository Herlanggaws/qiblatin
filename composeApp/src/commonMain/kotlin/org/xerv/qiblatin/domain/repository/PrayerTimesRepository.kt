package org.xerv.qiblatin.domain.repository

import org.xerv.qiblatin.domain.models.PrayerResponse

interface PrayerTimesRepository {
    suspend fun getPrayerTimes(
        city: String,
        country: String,
        date: String,
        method: Int = 2
    ): Result<PrayerResponse>
}