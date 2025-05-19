package org.xerv.qiblatin.data

import kotlinx.serialization.Serializable

@Serializable
data class PrayerTimeResponse(
    val code: Int,
    val status: String,
    val data: PrayerData
)
