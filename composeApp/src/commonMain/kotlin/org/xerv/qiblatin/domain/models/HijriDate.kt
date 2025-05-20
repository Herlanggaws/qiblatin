package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.HijriDateResponse

data class HijriDate(
    val date: String,
    val format: String,
    val day: String,
    val month: HijriMonth,
    val year: String
) {
    constructor(data: HijriDateResponse?) : this(
        date = data?.date.orEmpty(),
        format = data?.format.orEmpty(),
        day = data?.day.orEmpty(),
        month = HijriMonth(data?.month),
        year = data?.year.orEmpty(),
    )
}
