package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.HijriMonthResponse

data class HijriMonth(
    val number: Int,
    val en: String,
    val ar: String,
    val days: Int
) {
    constructor(data: HijriMonthResponse?) : this(
        number = data?.number ?: 0,
        en = data?.en.orEmpty(),
        ar = data?.ar.orEmpty(),
        days = data?.days ?: 0,
    )
}
