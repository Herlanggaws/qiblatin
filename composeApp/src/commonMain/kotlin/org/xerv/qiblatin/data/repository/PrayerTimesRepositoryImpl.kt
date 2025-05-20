package org.xerv.qiblatin.data.repository

import org.xerv.qiblatin.data.PrayerTimesApiService
import org.xerv.qiblatin.domain.models.PrayerResponse
import org.xerv.qiblatin.domain.repository.PrayerTimesRepository

class PrayerTimesRepositoryImpl(
    private val apiService: PrayerTimesApiService
) : PrayerTimesRepository {
    override suspend fun getPrayerTimes(
        city: String,
        country: String,
        date: String,
        method: Int
    ): Result<PrayerResponse> {
        return try {
            val response = apiService.getPrayerTimes(city, country, date, method)
            Result.success(PrayerResponse(response))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}