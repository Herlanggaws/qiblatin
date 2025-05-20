package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class PrayerDataResponse(
    val timings: PrayerTimingsResponse,
    val date: DateInfoResponse
)