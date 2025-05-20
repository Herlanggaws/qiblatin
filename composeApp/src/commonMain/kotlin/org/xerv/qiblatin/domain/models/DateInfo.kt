package org.xerv.qiblatin.domain.models

import org.xerv.qiblatin.data.response.DateInfoResponse

data class DateInfo(
    val readable: String,
    val timestamp: String,
    val hijri: HijriDate,
    val gregorian: GregorianDate
) {
    constructor(data: DateInfoResponse?) : this(
        readable = data?.readable.orEmpty(),
        timestamp = data?.timestamp.orEmpty(),
        hijri = HijriDate(data?.hijri),
        gregorian = GregorianDate(data?.gregorian),
    )
}
