package org.xerv.qiblatin.data.response

import kotlinx.serialization.Serializable

@Serializable
data class GregorianDateResponse(
    val date: String,
    val format: String,
    val day: String,
    val month: GregorianMonthResponse,
    val year: String,
    val weekday: WeekdayInfoResponse
)
