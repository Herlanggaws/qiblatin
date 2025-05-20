package org.xerv.qiblatin.domain.usecase

import org.xerv.qiblatin.domain.models.PrayerResponse
import org.xerv.qiblatin.domain.repository.PrayerTimesRepository

class GetPrayerTimesUseCase(
    private val repository: PrayerTimesRepository
) {
    suspend operator fun invoke(
        city: String,
        country: String,
        date: String,
        method: Int = 2
    ): Result<PrayerResponse> {
        return repository.getPrayerTimes(city, country, date, method)
    }
}