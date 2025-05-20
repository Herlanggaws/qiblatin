package org.xerv.qiblatin.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.xerv.qiblatin.data.response.PrayerResponseDto

class PrayerTimesApiServiceImpl(
    private val httpClient: HttpClient
) : PrayerTimesApiService {
    override suspend fun getPrayerTimes(
        city: String,
        country: String,
        date: String,
        method: Int
    ): PrayerResponseDto {
        return httpClient.get("https://api.aladhan.com/v1/timingsByCity/$date") {
            parameter("city", city)
            parameter("country", country)
            parameter("method", method)
        }.body()
    }
}