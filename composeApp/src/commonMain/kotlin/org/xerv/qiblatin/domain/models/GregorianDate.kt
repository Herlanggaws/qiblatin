package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.GregorianDateResponse

data class GregorianDate(
    val date: String,
    val format: String,
    val day: String,
    val month: GregorianMonth,
    val year: String
) {
    constructor(data: GregorianDateResponse?) : this(
        date = data?.date.orEmpty(),
        format = data?.format.orEmpty(),
        day = data?.day.orEmpty(),
        month = GregorianMonth(data?.month),
        year = data?.year.orEmpty(),
    )
}
