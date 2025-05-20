package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class PrayerTimeResponse(
    val code: Int,
    val status: String,
    val data: PrayerDataResponse
)
