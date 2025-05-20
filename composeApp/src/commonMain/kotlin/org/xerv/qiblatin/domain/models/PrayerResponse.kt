package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.PrayerResponseDto

data class PrayerResponse(
    val code: Int,
    val status: String,
    val data: PrayerData
) {
    constructor(data: PrayerResponseDto?): this (
        code = data?.code ?: 0,
        status = data?.status.orEmpty(),
        data = PrayerData(data?.data)
    )
}
