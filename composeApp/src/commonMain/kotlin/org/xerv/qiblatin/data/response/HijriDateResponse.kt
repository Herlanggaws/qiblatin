package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class HijriDateResponse(
    val date: String,
    val format: String,
    val day: String,
    val month: HijriMonthResponse,
    val year: String,
    val weekday: WeekdayInfoResponse
)
